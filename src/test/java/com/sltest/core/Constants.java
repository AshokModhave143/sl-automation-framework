package com.sltest.core;

public interface Constants {
	interface WEB_CONFIG {
		String WEB_URL = "https://test.strategyexe.com/users/login";
		String NODE_URL = "http://13.55.24.250:4444/wd/hub";
		String NODE_URL_LOCAL = "http://192.168.1.64:4444/wd/hub";
		String WINDOW_START_STATE = "--start-maximized";
		String WEB_PAGE_STATE = "return document.readyState";
		String WEB_PAGE_STATUS = "complete";
		// String EXECUTION_MODE = "headless";
	}
	
	interface CHROME_CONFIG {
		String VERSION = "92.0.4515.131";
		String DRIVER_PATH_LNUX = "/usr/bin/chromedriver";
		String EXE_PATH_LUNUX = "/usr/bin/google-chrome";
		String DRIVER_PATH_WINDOWS = "drivers12/chrome/chromedriver_92_0_4515_131.exe";
		String EXE_PATH_WINDOWS = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
		
		String CERTIFICATE_ERROR = "--ignore-certificate-error";
		String POP_UP_DISABLE = "--disable-popup-blocking";
		String WINDOW_SIZE = "--window-size=1920,1080";
		String SANDBOX_FLAG = "no-sandbox";
		String NOTIFICATION_DISABLE = "--disable-notifications";
	}
	
	interface FIREFOX_CONFIG {
		Boolean ACCEPT_FLAG = true;
        Boolean DECLINE_FLAG = false;
        String WINDOW_WIDTH = "--width=1920";
        String WINDOW_HEIGHT = "--height=1080";
        String NETWORK_PROXY = "network.proxy.type";
	}
	
	interface IE_CONFIG {
		
	}
	
	interface OPERA_CONFIG {
		
	}
}



//// browser versions
//private static String CHROME_VERSION = "92.0.4515.131";
//private static String IE_VERSION = "";
//private static String FIREFOX_VERSION = "";
//private static String EDGE_VERSION = "";
//
//// Linux
//private static String chromeDriverPath_LINUX = "/usr/bin/chromedriver";
//private static String chromePath_LINUX = "/usr/bin/google-chrome";
//
//// Windows
//private static String chromeDriverPath_WIDNOWS = "drivers/chrome/chromedriver_92_0_4515_131.exe";
//private static String chromePath_WINDOWS = "";
//private static String chromExePath_WINDOWS = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";