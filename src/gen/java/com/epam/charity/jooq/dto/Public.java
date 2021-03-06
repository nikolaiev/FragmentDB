/*
 * This file is generated by jOOQ.
*/
package com.epam.charity.jooq.dto;


import com.epam.charity.jooq.dto.tables.Gentables;
import com.epam.charity.jooq.dto.tables.Group;
import com.epam.charity.jooq.dto.tables.University;
import com.epam.charity.jooq.dto.tables.User;
import com.epam.charity.jooq.dto.tables.Userall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Public extends SchemaImpl {

    private static final long serialVersionUID = -89976106;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.GenTables</code>.
     */
    public final Gentables GENTABLES = com.epam.charity.jooq.dto.tables.Gentables.GENTABLES;

    /**
     * The table <code>public.Group</code>.
     */
    public final Group GROUP = com.epam.charity.jooq.dto.tables.Group.GROUP;

    /**
     * The table <code>public.University</code>.
     */
    public final University UNIVERSITY = com.epam.charity.jooq.dto.tables.University.UNIVERSITY;

    /**
     * The table <code>public.User</code>.
     */
    public final User USER = com.epam.charity.jooq.dto.tables.User.USER;

    /**
     * The table <code>public.UserAll</code>.
     */
    public final Userall USERALL = com.epam.charity.jooq.dto.tables.Userall.USERALL;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Gentables.GENTABLES,
            Group.GROUP,
            University.UNIVERSITY,
            User.USER,
            Userall.USERALL);
    }
}
