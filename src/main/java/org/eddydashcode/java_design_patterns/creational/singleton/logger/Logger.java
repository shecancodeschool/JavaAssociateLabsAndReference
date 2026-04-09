package org.eddydashcode.java_design_patterns.creational.singleton.logger;

public class Logger {

    private static volatile Logger instance;
    private final String message;


    private Logger(String message){
        this.message = message;
    }

    public static Logger getLogger(String message){
        if(instance == null){
            synchronized (Logger.class){  // for multithreaded environment
                if(instance == null){
                    instance = new Logger(message);
                }
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        return "[logger]::: " + message;
    }
}
