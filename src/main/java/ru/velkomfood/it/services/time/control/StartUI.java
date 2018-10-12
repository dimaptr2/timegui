package ru.velkomfood.it.services.time.control;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.velkomfood.it.services.time.control.config.Fabric;
import ru.velkomfood.it.services.time.control.database.DbManager;
import ru.velkomfood.it.services.time.control.logs.MyLogger;

import java.sql.SQLException;

public class StartUI extends Application {

    private Fabric generator;
    private MyLogger myLogger;
    private DbManager dbManager;
    private Stage window;

    @Override
    public void init() {

        generator = Fabric.createInstance().configure();
        myLogger = generator.getMyLogger();
        dbManager = generator.getDbManager();

        try {
            dbManager.openConnection();
        } catch (SQLException sqlEx) {
            myLogger.getLogger().warning(sqlEx.getMessage());
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        showMainWindow(window, generator);
    }

    @Override
    public void stop() {
        try {
            dbManager.closeConnection();
        } catch (SQLException sqEx) {
            myLogger.getLogger().warning(sqEx.getMessage());
        }
    }

    // Start Point
    public static void main(String[] args) {
        launch(args);
    }

    // private section

    private void showMainWindow(Stage win, Fabric fabric) {
        win.setTitle("Time Control UI");
        win.show();
    }

}
