package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static Logger Logger = LogManager.getLogger(Log.class.getName());

    public static void startTestCase(String sTestCaseName) {
        info("\n----------------- " + sTestCaseName + "\n");
    }

    //This is to print log for the ending of the test case
    public static void endTestCase(String sTestCaseName) {
        info("----------------- " + "-END TEST CASE-" + " -----------------");
    }

    // Need to create these methods, so that they can be called
    public static void info(String message) {
        Logger.info(message);
    }

    public static void warn(String message) {
        Logger.warn(message);
    }

    public static void error(String message) {
        Logger.error(message);
    }

    public static void fatal(String message) {
        Logger.fatal(message);
    }

    public static void debug(String message) {
        Logger.debug(message);
    }
}
