/**
 * 
 */
package com.flipkart.exception;

/**
 * @author devanshugarg
 *
 */
@SuppressWarnings("serial")
public class SeatNotAvailableException extends Exception {

	private int courseId;

	/**
	 * @param courseId
	 */
	public SeatNotAvailableException(int courseId) {
		this.courseId = courseId;
	}

	/**
	 * Getter Method
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}
	
	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() {
		return "Seats not available for course with Course Id: " + courseId + ".";
	}
}
