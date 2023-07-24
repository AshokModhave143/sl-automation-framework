package com.sltest.core;

import org.openqa.selenium.Capabilities;

import com.sltest.helper.DriverType;

public class CapabilityFactory {
	public Capabilities capabilities;
	
	public Capabilities getCapabilities(String browser) {
		DriverType type = DriverType.valueOf(browser.toUpperCase());

		switch(type) {
			case CHROME:
					capabilities = OptionsManager.getChromeOptions();
				break;
			case FIREFOX:
				capabilities = OptionsManager.getFirefoxOptions();
				break;
			case IE:
				break;
			default:
				return null;
		}
		return capabilities;
	}
}
