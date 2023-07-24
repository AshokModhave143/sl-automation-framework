package com.sltest.core;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class OptionsManager implements Constants {
	// Get chrome options
	public static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments(WEB_CONFIG.WINDOW_START_STATE);
		options.addArguments(CHROME_CONFIG.SANDBOX_FLAG);
		options.addArguments(CHROME_CONFIG.CERTIFICATE_ERROR);
		options.addArguments(CHROME_CONFIG.POP_UP_DISABLE);
		options.addArguments(CHROME_CONFIG.WINDOW_SIZE);
		options.addArguments(CHROME_CONFIG.NOTIFICATION_DISABLE);
		// options.addArguments(WEB_CONFIG.EXECUTION_MODE);
		
		return options;
	}
	
	// Get firefox options
	public static FirefoxOptions getFirefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		
		FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(FIREFOX_CONFIG.ACCEPT_FLAG);
        options.setHeadless(FIREFOX_CONFIG.ACCEPT_FLAG);
        options.addArguments(WEB_CONFIG.WINDOW_START_STATE);
        profile.setAssumeUntrustedCertificateIssuer(FIREFOX_CONFIG.DECLINE_FLAG);
        options.addArguments(FIREFOX_CONFIG.WINDOW_WIDTH);
        options.addArguments(FIREFOX_CONFIG.WINDOW_HEIGHT);
        profile.setPreference(FIREFOX_CONFIG.NETWORK_PROXY, 0);
        options.setCapability(FirefoxDriver.PROFILE, profile);
		
		return options;
	}
}
