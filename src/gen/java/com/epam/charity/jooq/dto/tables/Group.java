/*
 * This file is generated by jOOQ.
*/
package com.epam.charity.jooq.dto.tables;


import com.epam.charity.jooq.dto.Keys;
import com.epam.charity.jooq.dto.Public;
import com.epam.charity.jooq.dto.tables.records.GroupRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Group extends TableImpl<GroupRecord> {

    private static final long serialVersionUID = 768327420;

    /**
     * The reference instance of <code>public.Group</code>
     */
    public static final Group GROUP = new Group();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GroupRecord> getRecordType() {
        return GroupRecord.class;
    }

    /**
     * The column <code>public.Group.id</code>.
     */
    public final TableField<GroupRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('\"Group_id_seq\"'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.Group.title</code>.
     */
    public final TableField<GroupRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.Group.univ_id</code>.
     */
    public final TableField<GroupRecord, Long> UNIV_ID = createField("univ_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>public.Group</code> table reference
     */
    public Group() {
        this("Group", null);
    }

    /**
     * Create an aliased <code>public.Group</code> table reference
     */
    public Group(String alias) {
        this(alias, GROUP);
    }

    private Group(String alias, Table<GroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private Group(String alias, Table<GroupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<GroupRecord, Long> getIdentity() {
        return Keys.IDENTITY_GROUP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<GroupRecord> getPrimaryKey() {
        return Keys.ID_PK_GROUP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<GroupRecord>> getKeys() {
        return Arrays.<UniqueKey<GroupRecord>>asList(Keys.ID_PK_GROUP);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<GroupRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<GroupRecord, ?>>asList(Keys.GROUP__UNIV_ID_FK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Group as(String alias) {
        return new Group(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Group rename(String name) {
        return new Group(name, null);
    }
}