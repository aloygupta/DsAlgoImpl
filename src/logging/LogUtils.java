package logging;

import java.util.logging.*;

public class LogUtils {

    private Logger logger;
    private String TAG = "";
    private boolean isEnabled = false;



    private LogUtils(){
        // prevent default constructor
    }

    public LogUtils(String TAG, boolean enable){
        this.TAG = TAG;
        this.isEnabled = enable;
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

      /*  logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        logger.addHandler(handler);
        Formatter formatter = new MyFormatter();
        handler.setFormatter(formatter);*/
    }

    public void setEnable(boolean enable){
        this.isEnabled = enable;
    }

    public void logW(String msg){

        if(isEnabled){
            logger.setLevel(Level.WARNING);
            logger.warning(TAG+"---> "+ msg);
        }
    }

    public void logI(String msg){

        if(isEnabled){
            logger.setLevel(Level.INFO);
            logger.info(TAG+"---> "+msg);
        }

    }

    public void logS(String msg){

        if(isEnabled){
            logger.setLevel(Level.SEVERE);
            logger.severe(TAG+"---> "+msg);
        }
    }

    public void logAll(String msg){

        if(isEnabled){
            logger.setLevel(Level.ALL);
            logger.finest(TAG+"---> "+msg);
        }
    }

    static class MyFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            StringBuilder builder = new StringBuilder();
            //builder.append(record.getLevel() + ": ");
            //builder.append(formatMessage(record));
            builder.append(record.getMessage());
            builder.append(System.lineSeparator());
            // pre-Java7: builder.append(System.getProperty('line.separator'));
            return builder.toString();
        }
    }
}
