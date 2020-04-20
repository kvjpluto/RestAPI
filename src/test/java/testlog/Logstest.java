package testlog;

import org.apache.logging.log4j.*; 

public class Logstest {
	private static Logger log= LogManager.getLogger(Logstest.class.getName());
	public static void main(String[] args) {
		log.debug("I am Debugging new ");
		log.info("I m info new");
		log.error("I m error new");
		log.debug("I am Debugging new");
		log.info("I m info new");
		log.error("I m error new ");
	}
}
