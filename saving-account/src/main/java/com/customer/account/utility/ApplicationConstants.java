package com.customer.account.utility;

public interface ApplicationConstants {
	public final String CUSTOMER_DETAILS_URI = "customerDetailsUrl";
	public final String ACCOUNT_DETAILS_URI = "accountDetailsUrl";
	public final String USE_STAAS_CUSTOMER_DETAILS = "staasCustomerDetails";
	public final String USE_STAAS_ACCOUNT_DETAILS = "useStassAccountDetails";
	public final Integer ZERO = 0;
	public final String EMPTY_ERROR_MESSAGE = " cannot be null or empty";
	public final String ALPHA_ERROR_MESSAGE = " should contain only alphabets";
	public final String INVALID_DOB_ERROR = "Invalid date of Birth";
	
	public final String CUSTOMER_MESSAGE = "Customer";
	public final String SPACE = " ";
	public final String ACTUAL_VALUE = ", Actual value is [";
	public final String openingBracket = "[";
	public final String closingBracket = "]";
	public final String comma = ",";
	public final String CREATE = "C";
	public final String UPDATE = "U";

	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users/sign-up";
}
