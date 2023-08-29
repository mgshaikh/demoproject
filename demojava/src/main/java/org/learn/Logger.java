package org.learn;

/* create a Logger class using Singleton pattern.
*  method getLogger to return the instance of the Logger class
* method to log info, warning and error messages with exception
* the method should write the message to a file given a path as input using NIO Files class
* */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Logger {

    private static Logger logger = null;

    private String logFile = "log.txt" ;
    private Logger(String filepath) {
        this.logFile = filepath;
    }

    public static Logger getLogger(String filepath) {
        if(logger == null) {
            logger = new Logger(filepath);
        }
        return logger;
    }

    public void logInfo(String message) {
        log(message, "INFO");
    }

    public void logWarning(String message) {
        log(message, "WARNING");
    }

    public void logError(String message, Exception e) {
        log(message, "ERROR");
    }

    private void log(String message, String level) {
        try {
            Files.writeString(Path.of(logFile), level + " : " + message + "\n", StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

