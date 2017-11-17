package fr.eseo.criticalPfe.java.utils;

import java.util.logging.Logger;



public class Log {
private static Logger logger = Logger.getLogger(Log.class.getName());
	
	/**
	 * 
	 */
	private Log(){ 
		//nothing to do 
	}

	/**
	 * 
	 * @param s
	 */
	public static void info(String s) {

		StackTraceElement e = Thread.currentThread().getStackTrace()[2];
		String location = "";

		location += e.getFileName();
		location += " " + e.getClassName();
		location += " " + e.getMethodName();
		location += "() [l:" + Integer.toString(e.getLineNumber()) + "]\n";

		logger.info("\n"+ location+"\n"+s+"\n");
	}

	/**
	 * 
	 * @param s
	 */
	public static void warning(String s) {
		StackTraceElement e = Thread.currentThread().getStackTrace()[2];
		String location = "";

		location += e.getFileName();
		location += " " + e.getClassName();
		location += " " + e.getMethodName();
		location += "() [l:" + Integer.toString(e.getLineNumber()) + "]\n";

		logger.warning("\n" + location + "\n" + s + "\n");
	}
}
