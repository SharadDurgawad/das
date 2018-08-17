package com.customer.account.model;

import java.io.Serializable;

public class ApiResponseConstants implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1188633498047016187L;
	public static final String OK = "OK";
	public static final Integer OK_CODE = 200;
	public static final String CREATED = "Created";
	public static final Integer CREATED_CODE = 201;
	public static final String NO_CONTENT = "No Content";
	public static final Integer NO_CONTENT_CODE = 204;
	public static final String ACCEPTED = "Accepted";
	public static final Integer ACCEPTED_CODE = 202;
	public static final String MULTIPLE_CHOICES = "TBD Redirection Codes";
	public static final Integer MULTIPLE_CHOICES_CODE = 300;
	public static final String NOT_MODIFIED = "Not Modified";
	public static final Integer NOT_MODIFIED_CODE = 304;
	public static final String BAD_REQUEST = "Bad Request";
	public static final Integer BAD_REQUEST_CODE = 400;
	public static final String UNAUTHORIZED = "Unauthorized";
	public static final Integer UNAUTHORIZED_CODE = 401;
	public static final String FORBIDDEN = "Forbidden";
	public static final Integer FORBIDDEN_CODE = 403;
	public static final String NOT_FOUND = "Resource Not Found";
	public static final Integer NOT_FOUND_CODE = 404;
	public static final String METHOD_NOT_ALLOWED = "Method Not Allowed";
	public static final Integer METHOD_NOT_ALLOWED_CODE = 405;
	public static final String NOT_ACCEPTIBLE = "Not Acceptible";
	public static final Integer NOT_ACCEPTIBLE_CODE = 406;
	public static final String PRECONDITION_FAILED = "PreCondition Failed";
	public static final Integer PRECONDITION_FAILED_CODE = 412;
	public static final String UNSUPPORTED_MEDIA_TYPE = "Unsupported Media Type";
	public static final Integer UNSUPPORTED_MEDIA_TYPE_CODE = 415;
	public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
	public static final Integer INTERNAL_SERVER_ERROR_CODE = 500;
	public static final String NOT_IMPLEMENTED = "Not Implemented";
	public static final Integer NOT_IMPLEMENTED_CODE = 501;
	public static final String SERVER_NOT_AVAILABLE = "Server Not Available";
	public static final Integer SERVER_NOT_AVAILABLE_CODE = 503;
	public static final String DEFAULT_ERROR = INTERNAL_SERVER_ERROR;
	public static final Integer DEFAULT_ERROR_CODE = INTERNAL_SERVER_ERROR_CODE;
}
