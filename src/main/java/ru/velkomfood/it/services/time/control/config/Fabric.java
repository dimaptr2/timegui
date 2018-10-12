package ru.velkomfood.it.services.time.control.config;

import ru.velkomfood.it.services.time.control.database.DbManager;
import ru.velkomfood.it.services.time.control.logs.MyLogger;

public class Fabric {

    private static final Fabric instance = new Fabric();
    private MyLogger myLogger;
    private DbManager dbManager;

    private Fabric() { }

    public static Fabric createInstance() {
        return instance;
    }

    public Fabric configure() {
        myLogger = MyLogger.create();
        dbManager = DbManager.create();
        return this;
    }

    public MyLogger getMyLogger() {
        return myLogger;
    }

    public DbManager getDbManager() {
        return dbManager;
    }

}
