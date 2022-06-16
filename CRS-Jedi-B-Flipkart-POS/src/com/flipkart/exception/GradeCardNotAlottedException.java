/**
 * 
 */
package com.flipkart.exception;

/**
 * @author devanshugarg
 *
 */
@SuppressWarnings("serial")
public class GradeCardNotAlottedException extends Exception {

	private int studentId;

	/**
	 * @param studentId
	 */
	public GradeCardNotAlottedException(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * Getter Method
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}
	
	/**
	 * Message returned when Exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Student with Student Id: " + studentId + " is not alloted a Grade Card yet.";
	}
}
