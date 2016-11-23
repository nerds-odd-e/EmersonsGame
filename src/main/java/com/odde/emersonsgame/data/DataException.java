package com.odde.emersonsgame.data;

import java.sql.SQLException;

public class DataException extends RuntimeException {
    public DataException(SQLException e) {
        super(e);
    }
}
