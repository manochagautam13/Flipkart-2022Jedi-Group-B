/**
 * 
 */
package com.flipkart.exception;

/**
 * @author devanshugarg
 *
 */
@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
	
	private String userId;

	/**
	 * @param userId
	 */
	public UserNotFoundException(String userId) {
		this.userId = userId;
	}

	/**
	 * Getter Method
	 * @return the userEmailId
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * Message returned when Exception is thrown
	 */
	@Override
	public String getMessage() {
		return "User with User Id: " + userId + " not found.";
	}
}
