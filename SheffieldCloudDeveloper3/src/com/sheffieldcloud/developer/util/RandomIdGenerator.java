package com.sheffieldcloud.developer.util;

public class RandomIdGenerator {
   
	public static String generateUniqueId() {
		long uniqueId = System.currentTimeMillis();
		String uniqueIdAsString = "ACK" + String.valueOf(uniqueId);
		return uniqueIdAsString;
	}
}
