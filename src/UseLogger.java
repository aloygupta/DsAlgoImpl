import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UseLogger {
    // use the classname for the logger, this way you can refactor
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    public void doSomeThingAndLog() {
        // ... more code

        // now we demo the logging

        // set the LogLevel to Severe, only severe Messages will be written
        LOGGER.setLevel(Level.SEVERE);
        LOGGER.severe("sever Log");
        LOGGER.warning("warning Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Really not important");

        System.out.println("abc");

        // set the LogLevel to Info, severe, warning and info will be written
        // finest is still not written
        LOGGER.setLevel(Level.WARNING);
        LOGGER.severe("sever Log");
        LOGGER.warning("warning Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Really not important");

        System.out.println("def");

        LOGGER.setLevel(Level.INFO);
        LOGGER.severe("sever Log");
        LOGGER.warning("warning Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Really not important");
    }

    public static void main(String[] args) {
        UseLogger tester = new UseLogger();
       /* try {
            MyLogger.setup();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }*/
        tester.doSomeThingAndLog();
    }
}