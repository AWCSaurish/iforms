package com.awcsoftware.services.impl;

import java.util.Properties;

public class PropertiesReader {
	private static Properties prop;

	public static Properties getProp() {
		return prop;
	}

	public static void setProp(Properties prop) {
		PropertiesReader.prop = prop;
	}
	
}
