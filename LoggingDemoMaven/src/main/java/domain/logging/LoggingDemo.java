/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.logging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    static final Logger LOGGER = DefaultLogger.getLogger(false, false);
    
    public static void main(String[] args) throws IOException {
       LoggingDemo ld = new LoggingDemo();
       ld.run();
    }
    public void run() throws IOException{
        //Just log a message.
        LOGGER.log(Level.OFF, "Only this message will be logged");
        //Log a message: First anounce sevirity level, then the message and then a list of objects to be inserted in the message.
        LOGGER.log(Level.SEVERE, "This is the {0} to be {1}", new Object[]{"message", "logged"});
        //Log a Throwable
        LOGGER.log(Level.SEVERE, "Message to be logged", new RuntimeException("ERRRRROR"));
    }
}