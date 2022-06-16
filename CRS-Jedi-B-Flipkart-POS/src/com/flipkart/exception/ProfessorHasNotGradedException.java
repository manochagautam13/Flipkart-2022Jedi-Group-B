/**
 * 
 */
package com.flipkart.exception;

/**
 * @author HP
 *
 */
public class ProfessorHasNotGradedException extends Exception{
	
	private int studentId;

	/**
	 * @param studentId
	 */
	public ProfessorHasNotGradedException(int studentId) {
		this.studentId = studentId;
	}


	public ProfessorHasNotGradedException() {
		// TODO Auto-generated constructor stub
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
		return "Professor has not graded Student with Student Id: " + studentId;
	}
	

}
