/**
 * This class is generated by jOOQ
 */
package models.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.1.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Meeting extends org.jooq.impl.TableImpl<models.tables.records.MeetingRecord> {

	private static final long serialVersionUID = -1327690595;

	/**
	 * The singleton instance of <code>Meeting</code>
	 */
	public static final models.tables.Meeting MEETING = new models.tables.Meeting();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<models.tables.records.MeetingRecord> getRecordType() {
		return models.tables.records.MeetingRecord.class;
	}

	/**
	 * The column <code>Meeting.id</code>. 
	 */
	public final org.jooq.TableField<models.tables.records.MeetingRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>Meeting.title</code>. 
	 */
	public final org.jooq.TableField<models.tables.records.MeetingRecord, java.lang.String> TITLE = createField("title", org.jooq.impl.SQLDataType.CLOB, this);

	/**
	 * The column <code>Meeting.topic</code>. 
	 */
	public final org.jooq.TableField<models.tables.records.MeetingRecord, java.lang.String> TOPIC = createField("topic", org.jooq.impl.SQLDataType.CLOB, this);

	/**
	 * The column <code>Meeting.startTime</code>. 
	 */
	public final org.jooq.TableField<models.tables.records.MeetingRecord, java.sql.Timestamp> STARTTIME = createField("startTime", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>Meeting.endTime</code>. 
	 */
	public final org.jooq.TableField<models.tables.records.MeetingRecord, java.sql.Timestamp> ENDTIME = createField("endTime", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>Meeting.abilityToSendFiles</code>. 
	 */
	public final org.jooq.TableField<models.tables.records.MeetingRecord, java.lang.Boolean> ABILITYTOSENDFILES = createField("abilityToSendFiles", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>Meeting.authorLogin</code>. 
	 */
	public final org.jooq.TableField<models.tables.records.MeetingRecord, java.lang.String> AUTHORLOGIN = createField("authorLogin", org.jooq.impl.SQLDataType.CLOB, this);

	/**
	 * The column <code>Meeting.accessCode</code>. 
	 */
	public final org.jooq.TableField<models.tables.records.MeetingRecord, java.lang.String> ACCESSCODE = createField("accessCode", org.jooq.impl.SQLDataType.CLOB, this);

	/**
	 * Create a <code>Meeting</code> table reference
	 */
	public Meeting() {
		super("Meeting", models.DefaultSchema.DEFAULT_SCHEMA);
	}

	/**
	 * Create an aliased <code>Meeting</code> table reference
	 */
	public Meeting(java.lang.String alias) {
		super(alias, models.DefaultSchema.DEFAULT_SCHEMA, models.tables.Meeting.MEETING);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<models.tables.records.MeetingRecord> getPrimaryKey() {
		return models.Keys.PK_MEETING;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<models.tables.records.MeetingRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<models.tables.records.MeetingRecord>>asList(models.Keys.PK_MEETING);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public models.tables.Meeting as(java.lang.String alias) {
		return new models.tables.Meeting(alias);
	}
}
