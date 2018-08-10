package com.customer.account.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

	public static String getValidDateString(String dateOfBirth) {
		logger.debug("getValidDateString::Start");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dobString = null;
		try {
			Date dob = simpleDateFormat.parse(dateOfBirth);
			dobString = simpleDateFormat.format(dob);
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
		logger.debug("getValidDateString::End");
		return dobString;
	}
}
