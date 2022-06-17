/**
 * 
 */
package com.flipkart.exception;

/**
 * @author devanshugarg
 *
 */
@SuppressWarnings("serial")
public class CourseAlreadyExistsException extends Exception {
	
	private int courseId;

	/**
	 * @param courseId
	 */
	public CourseAlreadyExistsException(int courseId) {
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
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Course: " + courseId + " already exists in catalog.";
	}
}
