package com.yedam.common;

public class RetCode {
	public static String getRetCode(boolean rc) {
		if (rc) {
			return "{\"retCode\": \"Success\"}";
		} else {
			return "{\"retCode\": \"Fail\"}";
		}
	}
}
