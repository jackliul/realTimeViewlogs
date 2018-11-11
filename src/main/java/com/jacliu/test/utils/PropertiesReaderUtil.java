package com.jacliu.test.utils;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public class PropertiesReaderUtil {
	public static final ResourceBundle configBundle = ResourceBundle.getBundle("config");

	public static final String getConfigInfo(String key) {
		try {
			return new String(configBundle.getString(key).getBytes("ISO-8859-1"), "UTF8");
		} catch (UnsupportedEncodingException localUnsupportedEncodingException) {
		}
		return null;
	}
}
