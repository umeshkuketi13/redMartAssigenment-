package redMart.support.Loggerhelper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import redMart.support.Utill.ResourceHelper;




@SuppressWarnings("rawtypes")
public class LoggerHelper {

	private static boolean root = false;

	public static Logger getLogger(Class clas){
		if (root) {
			return Logger.getLogger(clas);
		}
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("/src/main/resources/configfile/log4j.properties"));
		root = true;
		return Logger.getLogger(clas);
	}
}
