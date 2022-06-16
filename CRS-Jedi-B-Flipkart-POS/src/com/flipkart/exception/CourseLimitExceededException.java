/**
 * 
 */
package com.flipkart.exception;

/**
 * @author devanshugarg
 *
 */
@SuppressWarnings("serial")
public class CourseLimitExceededException extends Exception {

	private int noOfCourses;

	/**
	 * @param noOfCourses
	 */
	public CourseLimitExceededException(int noOfCourses) {
		this.noOfCourses = noOfCourses;
	}

	/**
	 * Getter Method
	 * @return the noOfCourses
	 */
	public int getNoOfCourses() {
		return noOfCourses;
	}
	
	/**
	 * Message returned when Exception is thrown
	 */
	@Override
	public String getMessage() {
		return "You have already registered for " + noOfCourses + " courses.";
	}
}
