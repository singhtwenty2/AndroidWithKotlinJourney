package com.example.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;

/**
 * This class extends the SQLiteDialect class to provide SQLite specific
 * configuration.
 */
public class SQLiteDialect extends Dialect {

    /**
     * Returns the SQL syntax that adds a column to an existing table.
     * 
     * @return String - the SQL syntax that adds a column to an existing table.
     */
    @Override
    public String getAddColumnString() {
        return "add column";
    }

    /**
     * Returns the IdentityColumnSupport for SQLite which does not support identity
     * columns.
     *
     * @return an IdentityColumnSupport instance indicating that SQLite does not
     *         support identity columns.
     */
    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new IdentityColumnSupportImpl() {
            @Override
            public boolean supportsIdentityColumns() {
                return false;
            }
        };
    }
}