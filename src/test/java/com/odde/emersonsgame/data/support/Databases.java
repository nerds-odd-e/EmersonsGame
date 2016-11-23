package com.odde.emersonsgame.data.support;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

import java.io.FileInputStream;

public class Databases {
    public static IDatabaseTester getDatabaseTester() throws ClassNotFoundException {
        return new JdbcDatabaseTester("org.sqlite.JDBC", "jdbc:sqlite:emersonsgame.db");
    }

    public static IDataSet getDataSet(Class clazz) throws Exception {
        String file = "src/test/resources/dataset/" + clazz.getSimpleName() + ".xml";

        return new FlatXmlDataSetBuilder().build(new FileInputStream(file));
    }
}
