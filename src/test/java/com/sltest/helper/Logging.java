package com.sltest.helper;

import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class Logging {
	private static final Logger LOGGER = Logger.getLogger("logger");	
	private static PatternLayout layout = new PatternLayout("%d{dd MM yyyy HH:mm:ss} %5p %c{1} - %m%n");
	private static FileAppender appender;
	private static ConsoleAppender consoleAppender;
	
	static {
		try {
			consoleAppender = new ConsoleAppender(layout, "System.out");
			appender = new FileAppender(layout, "Logfile.txt", true);
		} catch(IOException e) {
			e.printStackTrace();
		}		 
	}
	
	// log error
	public static void logError(String className, String methodName, String exception) {
		LOGGER.addAppender(appender);
		LOGGER.setLevel((Level) Level.INFO);
		LOGGER.info("ClassName: " + className);
		LOGGER.info("MethodName :" + methodName);
		LOGGER.info("Exception :" + exception);
		LOGGER.info("---------------------------------------------------------------");
	}
	
	// log info
	public static void info(String message) {
		consoleAppender.setName("Console");
		LOGGER.addAppender(consoleAppender);
		LOGGER.addAppender(appender);
		LOGGER.setLevel((Level) Level.INFO);
		LOGGER.info(message);
	}
	
}
