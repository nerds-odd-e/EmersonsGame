package com.odde.emersonsgame.data.support;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import java.io.FileInputStream;

public class Databases {
    public static IDatabaseTester getDatabaseTester() throws ClassNotFoundException {
        IDatabaseTester databaseTester = new JdbcDatabaseTester("org.sqlite.JDBC", "jdbc:sqlite:emersonsgame.db");
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setTearDownOperation(DatabaseOperation.DELETE_ALL);

        return databaseTester;
    }

    public static IDataSet getDataSet(Class clazz) throws Exception {
        String file = "src/test/resources/dataset/" + clazz.getSimpleName() + ".xml";

        return new FlatXmlDataSetBuilder().build(new FileInputStream(file));
    }
}
