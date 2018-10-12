package ru.velkomfood.it.services.time.control.logs;

import java.util.logging.Logger;

public class MyLogger {

    private static final MyLogger instance = new MyLogger();
    private Logger logger;

    private MyLogger() {
        logger = Logger.getLogger("my-logger");
    }

    public static MyLogger create() {
        return instance;
    }

    public Logger getLogger() {
        return logger;
    }

}
