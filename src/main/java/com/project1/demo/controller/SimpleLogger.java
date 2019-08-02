//package com.project1.demo.controller;
//
//import net.bytebuddy.implementation.FieldAccessor;
//import org.jboss.logging.Logger;
//import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
//
//import java.util.Properties;
//
//public class SimpleLogger {
//    public static void main(String[] args) {
//        Properties properties = new Properties();
//
//        properties.setProperty("log4j.appender.MyFile.MaxFileSize", "10KB");
//        properties.setProperty("log4j.appender.MyFile.MaxBackupIndex", "1");
//
//        PropertyConfigurator.configure(properties);
//
//
//        Logger logger = Logger.getLogger("MyFile");
//
//        logger.fatal("This is a FATAL message.");
//        logger.error("This is an ERROR message.");
//        logger.warn("This is a WARN message.");
//        logger.info("This is an INFO message.");
//        logger.debug("This is a DEBUG message.");
//        logger.trace("This is a TRACE message.");
//    }
//}
//
