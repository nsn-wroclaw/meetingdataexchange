package controllers;
import java.io.File;
import java.sql.Timestamp;

import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.exception.DataAccessException;

import models.DbSingleton;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.io.Files;

import play.libs.Json;
import play.mvc.Content;
import play.mvc.Controller;
import play.mvc.Result;
import tools.MD5Checksum;
import static models.Tables.*;

public class FilesManagement extends Controller {
	
	public static Result upload(String login, String sid, String meetingid, String filename) throws DataAccessException, Exception {
		File file = request().body().asRaw().asFile();
		return ok(web_upload(login, sid, meetingid, file, filename));
	}
	
	public static ObjectNode web_upload(String login, String sid, String meetingid, File file, String filename) throws DataAccessException, Exception{
		if(login==null)
			return errorObject("Incorrect login");
		if(sid==null)
			return errorObject("Incorrect sid");
		if(meetingid==null)
			return errorObject("Incorrect meetingid");
		if(filename==null)
			return errorObject("Incorrect file name");
		
		
		if(!Meetings.userIsA_MemberOfMeeting(login, meetingid))
			return errorObject("Not a member of meeting");
		
		org.jooq.Result<Record1<Integer>> record = DbSingleton.getInstance().getDsl().select(MEETINGUSER.ID)
				.from(MEETING)
				.join(MEETINGUSER).on(MEETINGUSER.MEETINGID.equal(Integer.parseInt(meetingid)))
					.and(MEETINGUSER.USERLOGIN.equal(login))
				.where(MEETING.ID.equal(Integer.parseInt(meetingid)))
				.and(MEETING.ABILITYTOSENDFILES.isTrue().or(MEETING.AUTHORLOGIN.equal(login))).fetch();
		
		int meetinguserid;
		
		if(record.isEmpty())
			return errorObject("Upload forbidden");
		else
			meetinguserid = record.getValue(0, MEETINGUSER.ID);
		
		//Logger.info(System.getProperty("user.dir")+"/upload/"+meetingid+"/"+file.getName());
		
		File newFile = new File(System.getProperty("user.dir")+"/upload/"+meetingid+"/"+filename);
		
		if(newFile.exists())
			return errorObject("File with this name already exists");
			
		//File rawFile = request().body().asRaw().asFile();
		newFile.createNewFile();
		Files.copy(file, newFile);
		
		java.util.Date date= new java.util.Date();
		
		DbSingleton.getInstance().getDsl()
				.insertInto(FILE,
						FILE.MEETINGUSERID, FILE.NAME, FILE.SIZEKB, FILE.ADDEDTIME, FILE.HASHMD5)
				.values(meetinguserid, filename, 
						new Integer((int) Math.ceil(newFile.length()/1024.0)), new Timestamp(date.getTime()),
						MD5Checksum.getMD5Checksum(System.getProperty("user.dir")+"/upload/"+meetingid+"/"+filename))
				.execute();
		
		ObjectNode result = Json.newObject();
		result.put("status", "ok");
		return result;
	}
	
	public static Result remove(){
		JsonNode json = request().body().asJson();
		if(json == null)
			return errorResult("json excepted");
		
		String login = json.findPath("login").textValue();
		String sid = json.findPath("sid").textValue();
		String fileid = json.findPath("fileid").textValue();
		
		return ok(web_remove(login, sid, fileid));
	}


	public static ObjectNode web_remove(String login, String sid, String fileid) {
		if(!checkIsSidCorrect(login, sid))
			return errorObject("incorrect sid");
		
		org.jooq.Result<Record1<Integer>> record = DbSingleton.getInstance().getDsl()
				.select(MEETING.ID)
				.from(MEETING).join(MEETINGUSER).on(MEETING.ID.equal(MEETINGUSER.MEETINGID))
				.join(FILE).on(FILE.MEETINGUSERID.equal(MEETINGUSER.ID))
				.where(FILE.ID.equal(Integer.parseInt(fileid))).fetch();
		
		String meetingid = String.valueOf(record.getValue(0, MEETING.ID));
		
		if(!userIsA_Host(login, meetingid) && !userIsA_FileAuthor(login, fileid))
			return errorObject("access denied");
		
		if(meetingIsAlreadyFinish(meetingid))
			return errorObject("already finished");
		
		org.jooq.Result<Record1<String>> record2 = DbSingleton.getInstance().getDsl()
				.select(FILE.NAME)
				.from(FILE)
				.where(FILE.ID.equal(Integer.parseInt(fileid))).fetch();
		
		String filename = record2.getValue(0, FILE.NAME);
		
		File fileToDelete = new File(System.getProperty("user.dir")+"/upload/"+meetingid+"/"+filename);
		fileToDelete.delete();
		
		DbSingleton.getInstance().getDsl().delete(FILE).where(FILE.ID.equal(Integer.parseInt(fileid))).execute();
		
		ObjectNode result = Json.newObject();
		result.put("status", "ok");
		return result;
	}
	
	public static Result download(String login, String sid, String fileid){
		Object obj = web_download(login, sid, fileid);
		if(obj instanceof File)
			return ok((File) obj);
		else
			return ok((ObjectNode) obj);
	}
	
	public static Object web_download(String login, String sid, String fileid){
		if(!checkIsSidCorrect(login, sid))
			return errorObject("incorrect sid");
		
		org.jooq.Result<Record1<Integer>> record = DbSingleton.getInstance().getDsl()
				.select(MEETING.ID)
				.from(MEETING).join(MEETINGUSER).on(MEETING.ID.equal(MEETINGUSER.MEETINGID))
				.join(FILE).on(FILE.MEETINGUSERID.equal(MEETINGUSER.ID))
				.where(FILE.ID.equal(Integer.parseInt(fileid))).fetch();
		
		String meetingid = String.valueOf(record.getValue(0, MEETING.ID));
		
		if(!userIsA_MemberOfMeeting(login, meetingid))
			return errorObject("you are not a member");
		
		org.jooq.Result<Record1<String>> record2 = DbSingleton.getInstance().getDsl()
				.select(FILE.NAME)
				.from(FILE)
				.where(FILE.ID.equal(Integer.parseInt(fileid))).fetch();
		
		if(record2.isEmpty())
			return errorObject("file not found");
		
		String filename = record2.getValue(0, FILE.NAME);
		
		File fileToSend = new File(System.getProperty("user.dir")+"/upload/"+meetingid+"/"+filename);
		
		response().setContentType("application/x-download");  
		response().setHeader("Content-disposition","attachment; filename="+filename);
		return fileToSend;
	}
	
	
	
	public static Result comment(){
		JsonNode json = request().body().asJson();
		if(json == null)
			return errorResult("json excepted");
		
		String login = json.findPath("login").textValue();
		String sid = json.findPath("sid").textValue();
		String fileid = json.findPath("fileid").textValue();
		String content = json.findPath("content").textValue();
		
		return ok(web_comment(login, sid, fileid, content));
	}
	
	
	public static ObjectNode web_comment(String login, String sid, String fileid, String content) {
		if(!checkIsSidCorrect(login, sid))
			return errorObject("incorrect sid");
		
		org.jooq.Result<Record1<Integer>> record = DbSingleton.getInstance().getDsl()
				.select(MEETING.ID)
				.from(MEETING).join(MEETINGUSER).on(MEETING.ID.equal(MEETINGUSER.MEETINGID))
				.join(FILE).on(FILE.MEETINGUSERID.equal(MEETINGUSER.ID))
				.where(FILE.ID.equal(Integer.parseInt(fileid))).fetch();
		
		String meetingid = String.valueOf(record.getValue(0, MEETING.ID));
		if(!userIsA_MemberOfMeeting(login, meetingid))
			return errorObject("you are not a member");
		if(meetingIsAlreadyFinish(meetingid))
			return errorObject("meeting finished");
		
		java.util.Date date= new java.util.Date();
		
		Record record2 = DbSingleton.getInstance().getDsl()
				.insertInto(COMMENT,
						COMMENT.FILEID, COMMENT.USERLOGIN, COMMENT.DATE, COMMENT.CONTENT)
				.values(Integer.parseInt(fileid), login, new Timestamp(date.getTime()), content)
				.returning(COMMENT.ID)
				.fetchOne();
		
		ObjectNode result = Json.newObject();
		result.put("status", "ok");
		return result;
	}
	
	private static boolean userIsA_MemberOfMeeting(String login,
			String meetingId) {
		org.jooq.Result<Record> record = DbSingleton.getInstance().getDsl()
				.select()
				.from(MEETINGUSER)
				.where(MEETINGUSER.MEETINGID.equal(Integer.parseInt(meetingId)))
				.and(MEETINGUSER.USERLOGIN.equal(login)).fetch();
				if(record.isNotEmpty())
					return true;	
				else
					return false;
	}
	
	private static boolean checkIsSidCorrect(String login, String sid) {
		org.jooq.Result<Record> record = DbSingleton.getInstance().getDsl().select().from(SESSION)
				.where(SESSION.USERLOGIN.equal(login)).and(SESSION.SID.equal(sid)).fetch();
				if(record.isNotEmpty())
					return true;	
				else
					return false;
	}
	
	private static boolean userIsA_Host(String login, String meetingId) {
		org.jooq.Result<Record> record = DbSingleton.getInstance().getDsl()
					.select()
					.from(MEETING)
					.where(MEETING.ID.equal(Integer.parseInt(meetingId)))
					.and(MEETING.AUTHORLOGIN.equal(login))
				    .fetch();
				if(record.isNotEmpty())
					return true;	
				else
					return false;
	}
	
	private static boolean meetingIsAlreadyFinish(String meetingId) {
		org.jooq.Result<Record> record = DbSingleton.getInstance().getDsl()
					.select()
					.from(MEETING)
					.where(MEETING.ID.equal(Integer.parseInt(meetingId)))
					.and(MEETING.ENDTIME.isNotNull())
				    .fetch();
				if(record.isNotEmpty())
					return true;	
				else
					return false;
	}
	
	private static boolean userIsA_FileAuthor(String login, String fileid) {
		org.jooq.Result<Record> record = DbSingleton.getInstance().getDsl()
					.select()
					.from(FILE).join(MEETINGUSER).on(FILE.MEETINGUSERID.equal(MEETINGUSER.ID))
					.where(FILE.ID.equal(Integer.parseInt(fileid)))
					.and(MEETINGUSER.USERLOGIN.equal(login))
				    .fetch();
				if(record.isNotEmpty())
					return true;	
				else
					return false;
	}

	private static Result errorResult(String msg) {
		return ok(errorObject(msg));
	}
	
	
	private static ObjectNode errorObject(String msg){
		ObjectNode result = Json.newObject();
		result.put("status", "failed");
		result.put("reason", msg);
		return result;
	}
}
