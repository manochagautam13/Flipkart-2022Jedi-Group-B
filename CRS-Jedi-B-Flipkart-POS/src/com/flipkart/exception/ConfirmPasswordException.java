/**
 * 
 */
package com.flipkart.exception;

/**
 * @author HP
 *
 */
@SuppressWarnings("serial")
public class ConfirmPasswordException extends Exception{
	private int userId;

	/**
	 * @param userId
	 */
	public ConfirmPasswordException(int userId) {
		this.userId = userId;
	}

	public ConfirmPasswordException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getter Method
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Confirm Password and New Password are not similar";
	}
}
