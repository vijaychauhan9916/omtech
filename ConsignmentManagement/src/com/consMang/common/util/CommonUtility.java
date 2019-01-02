package com.consMang.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class CommonUtility {
	private static final Logger LOGGER = Logger.getLogger(CommonUtility.class);
	
	/**
	 * @param reqQTEndDate
	 * @return
	 */
	public static Calendar convertStringToDate(String reqQTEndDate) {
		LOGGER.debug(" ::  convertStringToDate() Started");
		reqQTEndDate = reqQTEndDate.replaceAll(" ", "");
		LOGGER.debug("reqQTEndDate : " + reqQTEndDate);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = null;
		try {
			date = sdf.parse(reqQTEndDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error(" Exception ::  convertStringToDate()");
			LOGGER.error(e);
		}
		Calendar qtEndDate = Calendar.getInstance();
		qtEndDate.setTime(date);
		LOGGER.debug("qtEndDate : " + qtEndDate.getTime());
		LOGGER.debug(" ::  convertStringToDate() Ended");
		return qtEndDate;
	}
}
