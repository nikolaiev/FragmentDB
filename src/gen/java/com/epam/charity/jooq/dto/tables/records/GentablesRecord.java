/*
 * This file is generated by jOOQ.
*/
package com.epam.charity.jooq.dto.tables.records;


import com.epam.charity.jooq.dto.tables.Gentables;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class GentablesRecord extends UpdatableRecordImpl<GentablesRecord> implements Record4<Long, String, String, String> {

    private static final long serialVersionUID = -455469393;

    /**
     * Setter for <code>public.GenTables.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.GenTables.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.GenTables.title</code>.
     */
    public void setTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.GenTables.title</code>.
     */
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.GenTables.author_name</code>.
     */
    public void setAuthorName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.GenTables.author_name</code>.
     */
    public String getAuthorName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.GenTables.view_name</code>.
     */
    public void setViewName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.GenTables.view_name</code>.
     */
    public String getViewName() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Gentables.GENTABLES.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Gentables.GENTABLES.TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Gentables.GENTABLES.AUTHOR_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Gentables.GENTABLES.VIEW_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getAuthorName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getViewName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GentablesRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GentablesRecord value2(String value) {
        setTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GentablesRecord value3(String value) {
        setAuthorName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GentablesRecord value4(String value) {
        setViewName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GentablesRecord values(Long value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GentablesRecord
     */
    public GentablesRecord() {
        super(Gentables.GENTABLES);
    }

    /**
     * Create a detached, initialised GentablesRecord
     */
    public GentablesRecord(Long id, String title, String authorName, String viewName) {
        super(Gentables.GENTABLES);

        set(0, id);
        set(1, title);
        set(2, authorName);
        set(3, viewName);
    }
}
