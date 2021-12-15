package com.spring.app.service;

import com.spring.app.interfaces.ILogger;

import java.util.logging.Level;

public class Logger implements ILogger {

    @Override
    public void log(Level level, String message, String className) {

        java.util.logging.Logger log  = java.util.logging.Logger.getLogger(className);
        log.log(level, message);
    }

}
