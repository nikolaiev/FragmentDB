/*
 * This file is generated by jOOQ.
*/
package com.epam.charity.jooq.dto.tables;


import com.epam.charity.jooq.dto.Keys;
import com.epam.charity.jooq.dto.Public;
import com.epam.charity.jooq.dto.tables.records.UniversityRecord;

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
public class University extends TableImpl<UniversityRecord> {

    private static final long serialVersionUID = 369988433;

    /**
     * The reference instance of <code>public.University</code>
     */
    public static final University UNIVERSITY = new University();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UniversityRecord> getRecordType() {
        return UniversityRecord.class;
    }

    /**
     * The column <code>public.University.id</code>.
     */
    public final TableField<UniversityRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('\"University_id_seq\"'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.University.title</code>.
     */
    public final TableField<UniversityRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.University.country</code>.
     */
    public final TableField<UniversityRecord, String> COUNTRY = createField("country", org.jooq.impl.SQLDataType.CLOB.nullable(false).defaultValue(org.jooq.impl.DSL.field("'Ukraine'::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * Create a <code>public.University</code> table reference
     */
    public University() {
        this("University", null);
    }

    /**
     * Create an aliased <code>public.University</code> table reference
     */
    public University(String alias) {
        this(alias, UNIVERSITY);
    }

    private University(String alias, Table<UniversityRecord> aliased) {
        this(alias, aliased, null);
    }

    private University(String alias, Table<UniversityRecord> aliased, Field<?>[] parameters) {
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
    public Identity<UniversityRecord, Long> getIdentity() {
        return Keys.IDENTITY_UNIVERSITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UniversityRecord> getPrimaryKey() {
        return Keys.UNIV_ID_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UniversityRecord>> getKeys() {
        return Arrays.<UniqueKey<UniversityRecord>>asList(Keys.UNIV_ID_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public University as(String alias) {
        return new University(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public University rename(String name) {
        return new University(name, null);
    }
}