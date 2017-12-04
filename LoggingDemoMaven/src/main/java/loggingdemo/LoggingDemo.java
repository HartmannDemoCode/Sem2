/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggingdemo;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author tha
 * Purpose: Show how to use the java.util.logging API.
 * Suggestion: Make a Logger object for each class that needs to be logged. Make the logger object static and final so all instances of the class will use the same logger instance.
 * Logger.getLogger(LoggingExamples.class.getName());
 * It is common practice to use the class name including package name as name for the Logger. The name of the Logger to create is passed as string parameter to the Logger.getLogger() method.
 * logger.addHandler() is how we add handlers that can write to console (Default) and a textfile, a network server...
 */
public class LoggingDemo {
    
    static final Logger LOGGER = Logger.getLogger(loggingdemo.LoggingDemo.class.getName());
    
    public static void main(String[] args) throws IOException {
       LoggingDemo ld = new LoggingDemo();
       ld.run();
    }
    public void run() throws IOException{
        //Just log a message.
        addHandlers();
        LOGGER.log(Level.OFF, "Only this message will be logged");
        //Log a message: First anounce sevirity level, then the message and then a list of objects to be inserted in the message.
        LOGGER.log(Level.SEVERE, "This is the {0} to be {1}", new Object[]{"message", "logged"});
        //Log a Throwable
        LOGGER.log(Level.SEVERE, "Message to be logged", new RuntimeException("ERRRRROR"));
        //Log with the hierachy: the chain of responsibility pattern
        Logger hierachicalLogger = createHierachyOfLoggers();
        hierachicalLogger.log(Level.SEVERE, "hierachical logging message", new RuntimeException("Hierachical logging of exception"));
    }
    private Logger createHierachyOfLoggers(){
        //This will create 4 loggers: The empty string logger is the root and the others are children of each other
        //Filters can be set on each logger : See more about creating filters in the documentation: http://tutorials.jenkov.com/java-logging/levels.html
        Logger logger  = Logger.getLogger(""); logger.addHandler(new ConsoleHandler());
        Logger logger1 = Logger.getLogger("com"); logger1.addHandler(new ConsoleHandler());
        Logger logger2 = Logger.getLogger("com.hartmannsolution"); logger2.addHandler(new ConsoleHandler());
        Logger logger3 = Logger.getLogger("com.hartmannsolution.www"); logger3.addHandler(new ConsoleHandler());
        return logger3;
    }
    private void addHandlers() throws IOException{
        LOGGER.addHandler(new ConsoleHandler());
        if(configuration.Conf.PRODUCTION){
            FileHandler handler = new FileHandler(configuration.Conf.LOGFILEPATH);
            handler.setFormatter(new SimpleFormatter());
            //handler.setFormatter(new MyFormatter());
            LOGGER.addHandler(handler);
            
        }
//        FileHandler handler = new FileHandler("loggingDemo-log.%u.%g.txt"); // see: http://tutorials.jenkov.com/java-logging/handlers.html
//        LOGGER.addHandler(handler);
        //Also available is:
        //StreamHandler - writes the log to any outputstream
        //SocketHandler - writes the log over TCP to a network host
        //MemoryHandler - keeps the log in memory like a buffer untill the buffer is full and then writes the log to a target handler.
    }
    private class MyFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return record.getLevel() + ":" + record.getMessage();
    }
}
}