/**
 * 
 */
package com.flipkart.exception;

/**
 *
 *
 */
@SuppressWarnings("serial")
public class CourseNotDeletedException extends Exception {

	private int courseId;

	/**
	 * @param courseId
	 */
	public CourseNotDeletedException(int courseId) {
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
		return "Course with Course Id: " + courseId + " can't be deleted.";
	}
	
}
