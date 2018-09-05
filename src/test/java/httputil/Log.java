package httputil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Log {
    private Class clazz;
    private Logger logger;

    private String logPath=Log.class.getClassLoader().getResource("log4j2.xml").getPath();

    File config = new File(logPath);
    public Log(Class clazz) {
        try{
            ConfigurationSource source = new ConfigurationSource(new FileInputStream(config),config);
            Configurator.initialize(null,source);
            this.clazz = clazz;
            this.logger = LogManager.getLogger(this.clazz);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void trace(String message){
        logger.trace(clazz.getSimpleName()+":"+message);
    }
    public void debug(String message){
        logger.trace(clazz.getSimpleName()+":"+message);
    }
    public void info(String message){
        logger.trace(clazz.getSimpleName()+":"+message);
    }

    public void error(String message){
        logger.trace(clazz.getSimpleName()+":"+message);
    }

    public static void main(String[] args){
        Log log = new Log(Log.class);
        log.info("info");
        log.debug("debug");
        log.error("error");
    }
}
