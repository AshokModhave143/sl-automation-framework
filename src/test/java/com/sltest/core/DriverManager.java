package com.sltest.core;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sltest.helper.DriverType;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static WebDriver driver;
	CapabilityFactory capabilityFactory = new CapabilityFactory();

	// Create browser driver object
	public WebDriver createWebDriver(String browserName) throws MalformedURLException {
		 return new RemoteWebDriver(new URL(Constants.WEB_CONFIG.NODE_URL), capabilityFactory.getCapabilities(browserName));
	}

	// get driver object
	public WebDriver getWebDriver(String browserName) {
		if (null == driver) {
			try {
				return createWebDriver(browserName);
			} catch(MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return driver;
	}

}
