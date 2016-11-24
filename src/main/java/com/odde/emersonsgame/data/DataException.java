package com.odde.emersonsgame.data;

import java.sql.SQLException;

public class DataException extends RuntimeException {
    public DataException() {
    }

    public DataException(SQLException e) {
        super(e);
    }
}
