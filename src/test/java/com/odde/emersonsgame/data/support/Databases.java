package com.odde.emersonsgame.data.support;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import java.io.FileInputStream;

public class Databases {
    private static IDatabaseTester databaseTester;

    public static IDatabaseTester getDatabaseTester(boolean reset) throws Exception {
        databaseTester = new JdbcDatabaseTester("org.sqlite.JDBC", "jdbc:sqlite:emersonsgame.db");
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setTearDownOperation(DatabaseOperation.DELETE_ALL);

        return databaseTester;
    }

    public static IDatabaseTester getDatabaseTester() throws Exception {
        if (databaseTester == null) {
            databaseTester = getDatabaseTester(true);
        }

        return databaseTester;
    }

    public static IDataSet getDataSet(String dataset) throws Exception {
        String file = "src/test/resources/dataset/" + dataset;

        return new FlatXmlDataSetBuilder().build(new FileInputStream(file));
    }
}
