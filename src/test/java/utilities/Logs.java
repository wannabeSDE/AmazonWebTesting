package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Logs.
 */
public class Logs {
    private static Logger logger = LogManager.getLogger();

    /**
     * Get info logs.
     *
     * @param message the message
     */
    public static void getInfoLogs(String message){
        logger.info(message);
    }

    /**
     * Get error logs.
     *
     * @param message the message
     */
    public static void getErrorLogs(String message){
        logger.error(message);
    }

    /**
     * Get warning logs.
     *
     * @param message the message
     */
    public static void getWarningLogs(String message){
        logger.warn(message);
    }

    /**
     * Get fatal logs.
     *
     * @param message the message
     */
    public static void getFatalLogs(String message){
        logger.fatal(message);
    }
}
