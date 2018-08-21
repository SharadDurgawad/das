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
}
