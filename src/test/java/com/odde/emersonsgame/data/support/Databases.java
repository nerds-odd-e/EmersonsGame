package com.odde.emersonsgame.data.support;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import java.io.FileInputStream;

public class Databases {
    private static IDatabaseTester databaseTester;

    public static IDatabaseTester getNewDatabaseTester() throws Exception {
        databaseTester = new JdbcDatabaseTester("org.sqlite.JDBC", "jdbc:sqlite:emersonsgame.db");
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);

        return databaseTester;
    }

    public static IDatabaseTester getDatabaseTester() throws Exception {
        if (databaseTester == null) {
            databaseTester = getNewDatabaseTester();
        }

        return databaseTester;
    }

    public static IDataSet getDataSet(String dataset) throws Exception {
        databaseTester.setTearDownOperation(DatabaseOperation.DELETE_ALL);

        String file = "src/test/resources/dataset/" + dataset;

        return new FlatXmlDataSetBuilder().build(new FileInputStream(file));
    }
}
