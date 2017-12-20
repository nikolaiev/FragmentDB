/*
 * This file is generated by jOOQ.
*/
package com.epam.charity.jooq.dto.tables;


import com.epam.charity.jooq.dto.Keys;
import com.epam.charity.jooq.dto.Public;
import com.epam.charity.jooq.dto.tables.records.GentablesRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
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
public class Gentables extends TableImpl<GentablesRecord> {

    private static final long serialVersionUID = 1322399625;

    /**
     * The reference instance of <code>public.GenTables</code>
     */
    public static final Gentables GENTABLES = new Gentables();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GentablesRecord> getRecordType() {
        return GentablesRecord.class;
    }

    /**
     * The column <code>public.GenTables.id</code>.
     */
    public final TableField<GentablesRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('\"GenTables_id_seq\"'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.GenTables.title</code>.
     */
    public final TableField<GentablesRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.GenTables.author_name</code>.
     */
    public final TableField<GentablesRecord, String> AUTHOR_NAME = createField("author_name", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.GenTables.view_name</code>.
     */
    public final TableField<GentablesRecord, String> VIEW_NAME = createField("view_name", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.GenTables.query</code>.
     */
    public final TableField<GentablesRecord, String> QUERY = createField("query", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>public.GenTables</code> table reference
     */
    public Gentables() {
        this("GenTables", null);
    }

    /**
     * Create an aliased <code>public.GenTables</code> table reference
     */
    public Gentables(String alias) {
        this(alias, GENTABLES);
    }

    private Gentables(String alias, Table<GentablesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Gentables(String alias, Table<GentablesRecord> aliased, Field<?>[] parameters) {
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
    public Identity<GentablesRecord, Long> getIdentity() {
        return Keys.IDENTITY_GENTABLES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<GentablesRecord> getPrimaryKey() {
        return Keys.GEN_TABLE_ID_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<GentablesRecord>> getKeys() {
        return Arrays.<UniqueKey<GentablesRecord>>asList(Keys.GEN_TABLE_ID_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Gentables as(String alias) {
        return new Gentables(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Gentables rename(String name) {
        return new Gentables(name, null);
    }
}