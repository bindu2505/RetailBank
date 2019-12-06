package com.bank.retailbanking.constants;

import org.springframework.http.HttpStatus;

public class ApplicationConstants {

	private ApplicationConstants() {
	}

	public static final String SAVING_ACCOUNT = "Saving";
	public static final Double OPENING_BALANCE = 3000.00;
	public static final Integer AGE_LIMIT = 18;
	public static final String INVALID_MOBILE = "Invalid mobile number";
	public static final String NOT_ELIGIBLE_FOR_ACCOUNT = "You are not eligible for individual bank account";
	public static final String INVALID_REGISTRATION_FOR_ACCOUNT = "Account with same email Id and mobile number already exists";
	public static final String INVALID_OPENING_BALANCE = "Account needs a minimum balance of 3000";

	public static final Integer SUCESS_STATUS_CODE = HttpStatus.OK.value();
	public static final String SUCCESS = "Success";
	public static final String FAILURE = "Failure";

}
