/**
 * 
 */
package com.flipkart.exception;

/**
 * @author devanshugarg
 *
 */
@SuppressWarnings("serial")
public class CourseAlreadyRegisteredException extends Exception {

//	private int courseId;

	/**
	 * @param
	 */
	public CourseAlreadyRegisteredException() {

	}

	/**
	 * Getter Method
	 * @return the courseId
	 */
//	public int getCourseId() {
//		return courseId;
//	}
	
	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() {
		return "You have already registered for the course with entered course";
	}
}
