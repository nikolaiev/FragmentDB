/*
 * This file is generated by jOOQ.
*/
package com.epam.charity.jooq.dto;


import com.epam.charity.jooq.dto.tables.Gentables;
import com.epam.charity.jooq.dto.tables.Group;
import com.epam.charity.jooq.dto.tables.University;
import com.epam.charity.jooq.dto.tables.User;
import com.epam.charity.jooq.dto.tables.Userall;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.GenTables</code>.
     */
    public static final Gentables GENTABLES = com.epam.charity.jooq.dto.tables.Gentables.GENTABLES;

    /**
     * The table <code>public.Group</code>.
     */
    public static final Group GROUP = com.epam.charity.jooq.dto.tables.Group.GROUP;

    /**
     * The table <code>public.University</code>.
     */
    public static final University UNIVERSITY = com.epam.charity.jooq.dto.tables.University.UNIVERSITY;

    /**
     * The table <code>public.User</code>.
     */
    public static final User USER = com.epam.charity.jooq.dto.tables.User.USER;

    /**
     * The table <code>public.UserAll</code>.
     */
    public static final Userall USERALL = com.epam.charity.jooq.dto.tables.Userall.USERALL;
}
