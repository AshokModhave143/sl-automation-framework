package com.sltest.core;

import java.util.HashMap;
import java.util.Map;

import net.bytebuddy.implementation.Implementation.Context;

public class ScenarioContext {

	private Map<String, Object> scenariContext;

	public ScenarioContext() {
		scenariContext = new HashMap<>();

	}

	public void setContextMethod(String key, Object value) {
		scenariContext.put(key.toString(), value);
	}

	public Object getContextMethod(String key) {
		return scenariContext.get(key.toString());
	}

	public boolean isContains(Context key) {
		return scenariContext.containsKey(key.toString());
	}

}
