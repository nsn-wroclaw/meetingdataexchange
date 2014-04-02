/**
 * This class is generated by jOOQ
 */
package models.public_;

/**
 * This class is generated by jOOQ.
 *
 * A class modelling foreign key relationships between tables of the <code>PUBLIC</code> 
 * schema
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.1.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.Identity<models.public_.tables.records.MeetingRecord, java.lang.Integer> IDENTITY_MEETING = Identities0.IDENTITY_MEETING;
	public static final org.jooq.Identity<models.public_.tables.records.UserRecord, java.lang.Integer> IDENTITY_USER = Identities0.IDENTITY_USER;
	public static final org.jooq.Identity<models.public_.tables.records.MeetinguserRecord, java.lang.Integer> IDENTITY_MEETINGUSER = Identities0.IDENTITY_MEETINGUSER;
	public static final org.jooq.Identity<models.public_.tables.records.FileRecord, java.lang.Integer> IDENTITY_FILE = Identities0.IDENTITY_FILE;
	public static final org.jooq.Identity<models.public_.tables.records.TypefileRecord, java.lang.Integer> IDENTITY_TYPEFILE = Identities0.IDENTITY_TYPEFILE;
	public static final org.jooq.Identity<models.public_.tables.records.CommentRecord, java.lang.Integer> IDENTITY_COMMENT = Identities0.IDENTITY_COMMENT;

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.UniqueKey<models.public_.tables.records.MeetingRecord> CONSTRAINT_6 = UniqueKeys0.CONSTRAINT_6;
	public static final org.jooq.UniqueKey<models.public_.tables.records.UserRecord> CONSTRAINT_2 = UniqueKeys0.CONSTRAINT_2;
	public static final org.jooq.UniqueKey<models.public_.tables.records.MeetinguserRecord> CONSTRAINT_4 = UniqueKeys0.CONSTRAINT_4;
	public static final org.jooq.UniqueKey<models.public_.tables.records.FileRecord> CONSTRAINT_20 = UniqueKeys0.CONSTRAINT_20;
	public static final org.jooq.UniqueKey<models.public_.tables.records.TypefileRecord> CONSTRAINT_65 = UniqueKeys0.CONSTRAINT_65;
	public static final org.jooq.UniqueKey<models.public_.tables.records.CommentRecord> CONSTRAINT_63 = UniqueKeys0.CONSTRAINT_63;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------


	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class Identities0 extends org.jooq.impl.AbstractKeys {
		public static org.jooq.Identity<models.public_.tables.records.MeetingRecord, java.lang.Integer> IDENTITY_MEETING = createIdentity(models.public_.tables.Meeting.MEETING, models.public_.tables.Meeting.MEETING.ID);
		public static org.jooq.Identity<models.public_.tables.records.UserRecord, java.lang.Integer> IDENTITY_USER = createIdentity(models.public_.tables.User.USER, models.public_.tables.User.USER.ID);
		public static org.jooq.Identity<models.public_.tables.records.MeetinguserRecord, java.lang.Integer> IDENTITY_MEETINGUSER = createIdentity(models.public_.tables.Meetinguser.MEETINGUSER, models.public_.tables.Meetinguser.MEETINGUSER.ID);
		public static org.jooq.Identity<models.public_.tables.records.FileRecord, java.lang.Integer> IDENTITY_FILE = createIdentity(models.public_.tables.File.FILE, models.public_.tables.File.FILE.ID);
		public static org.jooq.Identity<models.public_.tables.records.TypefileRecord, java.lang.Integer> IDENTITY_TYPEFILE = createIdentity(models.public_.tables.Typefile.TYPEFILE, models.public_.tables.Typefile.TYPEFILE.ID);
		public static org.jooq.Identity<models.public_.tables.records.CommentRecord, java.lang.Integer> IDENTITY_COMMENT = createIdentity(models.public_.tables.Comment.COMMENT, models.public_.tables.Comment.COMMENT.ID);
	}

	private static class UniqueKeys0 extends org.jooq.impl.AbstractKeys {
		public static final org.jooq.UniqueKey<models.public_.tables.records.MeetingRecord> CONSTRAINT_6 = createUniqueKey(models.public_.tables.Meeting.MEETING, models.public_.tables.Meeting.MEETING.ID);
		public static final org.jooq.UniqueKey<models.public_.tables.records.UserRecord> CONSTRAINT_2 = createUniqueKey(models.public_.tables.User.USER, models.public_.tables.User.USER.ID);
		public static final org.jooq.UniqueKey<models.public_.tables.records.MeetinguserRecord> CONSTRAINT_4 = createUniqueKey(models.public_.tables.Meetinguser.MEETINGUSER, models.public_.tables.Meetinguser.MEETINGUSER.ID);
		public static final org.jooq.UniqueKey<models.public_.tables.records.FileRecord> CONSTRAINT_20 = createUniqueKey(models.public_.tables.File.FILE, models.public_.tables.File.FILE.ID);
		public static final org.jooq.UniqueKey<models.public_.tables.records.TypefileRecord> CONSTRAINT_65 = createUniqueKey(models.public_.tables.Typefile.TYPEFILE, models.public_.tables.Typefile.TYPEFILE.ID);
		public static final org.jooq.UniqueKey<models.public_.tables.records.CommentRecord> CONSTRAINT_63 = createUniqueKey(models.public_.tables.Comment.COMMENT, models.public_.tables.Comment.COMMENT.ID);
	}
}
