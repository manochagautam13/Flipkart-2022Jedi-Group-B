/**
 * 
 */
package com.flipkart.exception;

/**
 * @author devanshugarg
 *
 */
@SuppressWarnings("serial")
public class StudentIdAlreadyInUseException extends Exception {

	private int studentId;

	/**
	 * @param studentId
	 */
	public StudentIdAlreadyInUseException(int studentId) {
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
		return "Student Id: " + studentId + " is already in use.";
	}
}
