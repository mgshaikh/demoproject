package org.learn;

public class LoggerApp {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("D:\\applog.txt");
        logger.logInfo("This is an info message");
        logger.logWarning("This is a warning message");
        logger.logError("This is an error message", new Exception("This is an exception"));
    }
}
