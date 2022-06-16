package com.flipkart.exception;

import java.sql.SQLException;

@SuppressWarnings("serial")
public class OldPasswordNotValidException extends SQLException {
	private String userId;

	/**
	 * @param userId
	 */
	public OldPasswordNotValidException(String userId) {
		this.userId = userId;
	}

	public OldPasswordNotValidException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getter Method
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Old Password is not valid Or User Id is incorrect";
	}
}
