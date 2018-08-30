package com.customer.account.utility;

public interface ApplicationConstants {
	
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
	
	public static final String BASE_PACKAGE = "basepackage";
	public static final String REGEX_FOR_SCAN= "regexforscan";
	public static final String CUSTOMER_API_TAG = "customerapitag";
	public static final String CUSTOMER_API_TAG_MESSAGE= "customerapitagmessage";
	public static final String USER_API_TAG = "userapitag";
	public static final String USER_API_TAG_MESSAGE = "userapitagmessage";
	public static final String SWAGGER_APPLICATION_INFO = "swaggerapplicationinfo";
	public static final String SWAGGER_APPLICATION_DESC = "swaggerapplicationdesciption";
	public static final String SWAGGER_APPLICATION_VERSION = "swaggerapplicationversion";
	public static final String SWAGGER_APPLICATION_CREATEDBY = "swaggerapplicationcreatedby";
	public static final String SWAGGER_APPLICATION_CONTACT = "swaggerapplicationcontact";
	public static final String SWAGGER_APPLICATION_WEBSITE = "swaggerapplicationwebsite";
	public static final String SWAGGER_APPLICATION_EMAIL = "swaggerapplicationemail";
	public static final String SWAGGER_APPLICATION_LICENCE_VERSION = "swaggerapplicationlicenceversion";
	public static final String SWAGGER_APPLICATION_LICENCE_URL = "swaggerapplicationlicenceurl";
			
}
