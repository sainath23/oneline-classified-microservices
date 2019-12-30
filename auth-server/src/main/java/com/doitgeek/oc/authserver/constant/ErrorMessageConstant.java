package com.doitgeek.oc.authserver.constant;

public class ErrorMessageConstant {

    public static final String USER_ACCOUNT_DOES_NOT_EXIST = "User account does not exists for id [%s]";
    public static final String USER_ACCOUNT_EXIST = "User account already exist!";
    public static final String DUPLICATE_EMAIL = "Email already exist";
    public static final String DUPLICATE_MOBILE_NUMBER = "Mobile number already exist";

    public static final String VALIDATION_FAILED = "Validation failed";
    public static final String METHOD_ARG_TYPE_MISMATCH = "%s should be of type %s";

    public static final String EMAIL_REQUIRED = "Email is required";
    public static final String USERNAME_REQUIRED = "Username is required";
    public static final String PASSWORD_REQUIRED = "Password is required";
    public static final String MOBILE_NO_REQUIRED = "Mobile number is required";

    public static final String PASSWORD_VALID = "Password length must be between 6 to 20 characters";
    public static final String MOBILE_NO_VALID = "Mobile number must be between 8 to 20 digits";
    public static final String EMAIL_VALID = "Email must be valid";
    public static final String EMAIL_SIZE = "Email size must be less than or equal to 255 characters";
    public static final String USERNAME_VALID = "Username must be valid";
    public static final String USERNAME_SIZE = "Username length must be less than or equal to 50 characters";
}
