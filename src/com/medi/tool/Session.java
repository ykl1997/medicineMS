package com.medi.tool;

import java.util.HashMap;
import java.util.Map;

public class Session {

	private static Map<String, Object> session = new HashMap<String, Object>();

	public static void setAttribute(String key, Object value) {
		session.put(key, value);
	}

	public static Object getAttribute(String key) {
		return session.get(key);
	}

	public static void removeAttribute(String key) {
		session.remove(key);
	}

}
