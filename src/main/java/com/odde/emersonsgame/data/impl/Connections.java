package com.odde.emersonsgame.data.impl;

import com.odde.emersonsgame.data.DataException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:emersonsgame.db");
        } catch (SQLException e) {
            throw new DataException(e);
        }
    }
}
