/**
 * 
 */
package com.flipkart.exception;

/**
 * @author devanshugarg
 *
 */
@SuppressWarnings("serial")
public class ProfessorNotDeletedException extends Exception {

	private int professorId;

	/**
	 * @param professorId
	 */
	public ProfessorNotDeletedException(int professorId) {
		this.professorId = professorId;
	}

	/**
	 * Getter Method
	 * @return the professorId
	 */
	public int getProfessorId() {
		return professorId;
	}
	
	/**
	 * Message returned when Exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Professer with Professor Id: " + professorId + " can't be deleted.";
	}
}
