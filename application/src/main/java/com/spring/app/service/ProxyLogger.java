package com.spring.app.service;

import com.spring.app.interfaces.ILogger;

import java.util.logging.Level;

public class ProxyLogger implements ILogger {
    Logger logger;

    @Override
    public void log(Level level, String message, String className) {
        if(logger == null)
        {
            logger = new Logger();
        }
        logger.log(level, message, className);
    }
}
