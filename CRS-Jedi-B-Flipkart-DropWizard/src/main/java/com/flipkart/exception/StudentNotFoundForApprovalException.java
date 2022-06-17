/**
 * 
 */
package com.flipkart.exception;

/**
 * @author devanshugarg
 *
 */
@SuppressWarnings("serial")
public class StudentNotFoundForApprovalException extends Exception {

	private int studentId;

	/**
	 * @param studentId
	 */
	public StudentNotFoundForApprovalException(int studentId) {
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
		return "Student with Student Id: " + studentId + " is not registered.";
	}
}
