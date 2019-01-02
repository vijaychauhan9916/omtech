package com.consMang.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CommonConstants {
	private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(CommonConstants.class);
	
	public static final String ADMIN_USER = "ADMIN";
	public static final String SES_USER_ATTR = "RERA_USER_ATTR";
	public static final String SES_USER_ROLE = "RERA_USER_ROLE";
	public static final String ACTIVE = "ACTIVE";
	public static final String INACTIVE = "INACTIVE";
	

	public static final DateFormat DATE_FORMATE = new SimpleDateFormat("ddMMyy");
	public static final Integer MAX_RESULT = 10;
	public static final Integer OFF_SET = 0;
	
	public interface UserProfileType{
		public static final String RECEIVER="RECEIVER";
		public static final String CONSIGNEE="CONSIGNEE";
	}
	public static final Calendar HC_DATE_LIMIT = new GregorianCalendar(2018, Calendar.MAY, 19);
	
	public static final String KEY_ENC_DNC = "FFFFFF3229A0B371EDDDDFFFFFAABBFFABBD2D9441B830D21A390C3";
	
}
