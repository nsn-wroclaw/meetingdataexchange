/**
 * This class is generated by jOOQ
 */
package models.public_.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.1.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MeetingRecord extends org.jooq.impl.UpdatableRecordImpl<models.public_.tables.records.MeetingRecord> implements org.jooq.Record7<java.lang.Integer, java.lang.String, java.lang.String, java.sql.Timestamp, java.sql.Timestamp, java.lang.Boolean, java.lang.Integer> {

	private static final long serialVersionUID = -1460561927;

	/**
	 * Setter for <code>PUBLIC.MEETING.ID</code>. 
	 */
	public void setId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>PUBLIC.MEETING.ID</code>. 
	 */
	public java.lang.Integer getId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>PUBLIC.MEETING.TITLE</code>. 
	 */
	public void setTitle(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>PUBLIC.MEETING.TITLE</code>. 
	 */
	public java.lang.String getTitle() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>PUBLIC.MEETING.TOPIC</code>. 
	 */
	public void setTopic(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>PUBLIC.MEETING.TOPIC</code>. 
	 */
	public java.lang.String getTopic() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>PUBLIC.MEETING.STARTTIME</code>. 
	 */
	public void setStarttime(java.sql.Timestamp value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>PUBLIC.MEETING.STARTTIME</code>. 
	 */
	public java.sql.Timestamp getStarttime() {
		return (java.sql.Timestamp) getValue(3);
	}

	/**
	 * Setter for <code>PUBLIC.MEETING.ENDTIME</code>. 
	 */
	public void setEndtime(java.sql.Timestamp value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>PUBLIC.MEETING.ENDTIME</code>. 
	 */
	public java.sql.Timestamp getEndtime() {
		return (java.sql.Timestamp) getValue(4);
	}

	/**
	 * Setter for <code>PUBLIC.MEETING.ABILITYTOSENDFILES</code>. 
	 */
	public void setAbilitytosendfiles(java.lang.Boolean value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>PUBLIC.MEETING.ABILITYTOSENDFILES</code>. 
	 */
	public java.lang.Boolean getAbilitytosendfiles() {
		return (java.lang.Boolean) getValue(5);
	}

	/**
	 * Setter for <code>PUBLIC.MEETING.AUTHORID</code>. 
	 */
	public void setAuthorid(java.lang.Integer value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>PUBLIC.MEETING.AUTHORID</code>. 
	 */
	public java.lang.Integer getAuthorid() {
		return (java.lang.Integer) getValue(6);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Integer> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record7 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.Integer, java.lang.String, java.lang.String, java.sql.Timestamp, java.sql.Timestamp, java.lang.Boolean, java.lang.Integer> fieldsRow() {
		return (org.jooq.Row7) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.Integer, java.lang.String, java.lang.String, java.sql.Timestamp, java.sql.Timestamp, java.lang.Boolean, java.lang.Integer> valuesRow() {
		return (org.jooq.Row7) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return models.public_.tables.Meeting.MEETING.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return models.public_.tables.Meeting.MEETING.TITLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return models.public_.tables.Meeting.MEETING.TOPIC;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field4() {
		return models.public_.tables.Meeting.MEETING.STARTTIME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field5() {
		return models.public_.tables.Meeting.MEETING.ENDTIME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field6() {
		return models.public_.tables.Meeting.MEETING.ABILITYTOSENDFILES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field7() {
		return models.public_.tables.Meeting.MEETING.AUTHORID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getTitle();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getTopic();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value4() {
		return getStarttime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value5() {
		return getEndtime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value6() {
		return getAbilitytosendfiles();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value7() {
		return getAuthorid();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached MeetingRecord
	 */
	public MeetingRecord() {
		super(models.public_.tables.Meeting.MEETING);
	}
}
