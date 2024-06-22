package com.example.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;

import java.sql.Types;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        registerColumnType(Types.BLOB, "blob");
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.VARCHAR, "text");
    }

    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new SQLiteIdentityColumnSupport();
    }

    private static class SQLiteIdentityColumnSupport extends IdentityColumnSupportImpl {
        @Override
        public boolean supportsIdentityColumns() {
            return true;
        }

        @Override
        public boolean hasDataTypeInIdentityColumn() {
            return false;
        }

        @Override
        public String getIdentityColumnString(int type) {
            return "integer";
        }
    }

    @Override
    public String getAddColumnString() {
        return "add column";
    }
}
