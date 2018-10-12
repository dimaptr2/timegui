package ru.velkomfood.it.services.time.control.database;

import java.sql.Connection;
import java.sql.SQLException;

public class DbManager {

    private static final DbManager instance = new DbManager();
    private Connection connection;

    private DbManager() { }

    public static DbManager create() {
        return instance;
    }

    public void openConnection() throws SQLException {

    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
