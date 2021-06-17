package logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtils {

    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private String TAG = "";
    private boolean isEnabled = false;

    private LogUtils(){
        // prevent default constructor
    }

    public LogUtils(String TAG, boolean enable){
        this.TAG = TAG;
        this.isEnabled = enable;


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
}
