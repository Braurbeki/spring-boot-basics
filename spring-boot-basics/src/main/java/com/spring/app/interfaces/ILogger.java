package com.spring.app.interfaces;

import java.util.logging.Level;

public interface ILogger {
    void log(Level level, String message, String className);
}
