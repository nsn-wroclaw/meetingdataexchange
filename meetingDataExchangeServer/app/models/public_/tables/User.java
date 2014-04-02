/**
 * This class is generated by jOOQ
 */
package models.public_.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.1.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User extends org.jooq.impl.TableImpl<models.public_.tables.records.UserRecord> {

	private static final long serialVersionUID = 864242546;

	/**
	 * The singleton instance of <code>PUBLIC.USER</code>
	 */
	public static final models.public_.tables.User USER = new models.public_.tables.User();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<models.public_.tables.records.UserRecord> getRecordType() {
		return models.public_.tables.records.UserRecord.class;
	}

	/**
	 * The column <code>PUBLIC.USER.ID</code>. 
	 */
	public final org.jooq.TableField<models.public_.tables.records.UserRecord, java.lang.Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>PUBLIC.USER.NAME</code>. 
	 */
	public final org.jooq.TableField<models.public_.tables.records.UserRecord, java.lang.String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.USER.EMAIL</code>. 
	 */
	public final org.jooq.TableField<models.public_.tables.records.UserRecord, java.lang.String> EMAIL = createField("EMAIL", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.USER.PASSWORD</code>. 
	 */
	public final org.jooq.TableField<models.public_.tables.records.UserRecord, java.lang.String> PASSWORD = createField("PASSWORD", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * Create a <code>PUBLIC.USER</code> table reference
	 */
	public User() {
		super("USER", models.public_.Public.PUBLIC);
	}

	/**
	 * Create an aliased <code>PUBLIC.USER</code> table reference
	 */
	public User(java.lang.String alias) {
		super(alias, models.public_.Public.PUBLIC, models.public_.tables.User.USER);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<models.public_.tables.records.UserRecord, java.lang.Integer> getIdentity() {
		return models.public_.Keys.IDENTITY_USER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<models.public_.tables.records.UserRecord> getPrimaryKey() {
		return models.public_.Keys.CONSTRAINT_2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<models.public_.tables.records.UserRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<models.public_.tables.records.UserRecord>>asList(models.public_.Keys.CONSTRAINT_2);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public models.public_.tables.User as(java.lang.String alias) {
		return new models.public_.tables.User(alias);
	}
}
