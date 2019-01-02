package com.consMang.common.util;

import java.util.Calendar;

import org.apache.log4j.Logger;

public class GenerateRegistrationNumber {
	private static final Logger LOGGER = Logger.getLogger(GenerateRegistrationNumber.class);
	

	public static String generateBCRNo(long totalReq) {
		LOGGER.debug(" ::  generateBCRNo() Started");
		StringBuffer sb = new StringBuffer();
		sb.append("BCR/");
		 String formatted = String.format("%07d", ++totalReq);
		sb.append(formatted);
		sb.append("/");
		Calendar cal=Calendar.getInstance();
		sb.append(String.format("%02d",cal.get(Calendar.DATE)));
		sb.append(String.format("%02d",cal.get(Calendar.MONTH) + 1));
		sb.append(cal.get(Calendar.YEAR));
		LOGGER.debug(" ::  generateBCRNo() Ended");
		return sb.toString();
	}
}
