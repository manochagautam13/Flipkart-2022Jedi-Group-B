/**
 * 
 */
package com.flipkart.exception;

/**
 * @author devanshugarg
 *
 */
@SuppressWarnings("serial")
public class CourseNotFoundException extends Exception {

	private int courseId;

	/**
	 * @param courseId
	 */
	public CourseNotFoundException(int courseId) {
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
		return "Course with Course Id: " + courseId + " not found.";
	}
}
