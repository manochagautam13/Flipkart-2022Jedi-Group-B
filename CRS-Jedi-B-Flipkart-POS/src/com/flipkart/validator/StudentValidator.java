/**
 * 
 */
package com.flipkart.validator;


import com.flipkart.bean.Course;
import com.flipkart.exception.CourseNotFoundException;

import java.util.Vector;

/**
 * @author devanshugarg
 *
 */
public class StudentValidator {

	/**
	 * 
	 * @param courseId
	 * @param studentId
	 * @param registeredCourseList  
	 * @return 
	 * @throws CourseNotFoundException
	 */
	public static boolean isRegistered(int courseId, int studentId, Vector<Course> registeredCourseList) throws CourseNotFoundException {
		
		for(Course course : registeredCourseList) {
			if(courseId == course.getCourseId()) {
				return true; 
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param courseId
	 * @param availableCourseList
	 * @return 
	 */
	public static boolean isValidCourseCode(int courseId, Vector<Course> availableCourseList) {
		
		for(Course course : availableCourseList) {
			if(courseId == course.getCourseId()) {
				return true; 
			}
		}
		return false;
	}
}
