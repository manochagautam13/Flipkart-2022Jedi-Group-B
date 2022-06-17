/**
 * 
 */
package com.flipkart.exception;

/**
 * @author anirudhagupta
 *
 */
@SuppressWarnings("serial")
public class ProfessorAlreadyRegisteredException extends Exception {

	private int professorId;

	/**
	 * @param professorId
	 */
	public ProfessorAlreadyRegisteredException(int professorId) {
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
		return "Professer with Professor Id: " + professorId + " has already registered.";
	}
}
