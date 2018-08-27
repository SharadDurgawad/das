package com.customer.account.utility;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class CommonUtil {
	public static void validateField(String fieldName, String fieldValue, boolean isAlphaOnly,
			List<String> validationErrors) {
		if (StringUtils.isNotEmpty(fieldValue)) {
			if (isAlphaOnly && !StringUtils.isAlpha(fieldValue)) {
				validationErrors.add(fieldName + ApplicationConstants.ALPHA_ERROR_MESSAGE
						+ ApplicationConstants.ACTUAL_VALUE + fieldValue + ApplicationConstants.closingBracket);
			}
		} else {
			validationErrors.add(fieldName + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		}
	}

	/**
	 * Returns the name of the caller class and its method.
	 * 
	 * @return
	 */
	public static String getCallingClassAndMethodName() {
		return new StringBuilder().append(getCallingClassName()).append(".").append(getCallingMethodName()).toString();
	}

	/**
	 * Returns the name of the caller class and its method.
	 * 
	 * @return
	 */
	public static String getCallingClassAndMethodName(String action) {
		return new StringBuilder().append(getCallingClassName()).append(".").append(getCallingMethodName())
				.append(" : ").append(action).toString();
	}

	/**
	 * Get the name of the class whose method calls this method.
	 * 
	 * @return
	 */
	private static String getCallingClassName() {
		StackTraceElement[] callStack = Thread.currentThread().getStackTrace();
		return callStack[3].getClassName().contains(".")
				? callStack[3].getClassName().substring(callStack[3].getClassName().lastIndexOf('.') + 1)
				: callStack[3].getClassName();
	}

	/**
	 * Get the name of the method which calls this method.
	 * 
	 * @return
	 */
	private static String getCallingMethodName() {
		return Thread.currentThread().getStackTrace()[3].getMethodName();
	}
}
