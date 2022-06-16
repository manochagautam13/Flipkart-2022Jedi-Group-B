/**
 * 
 */
package com.flipkart.validator;


import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.Vector;

/**
 * @author devanshugarg
 *
 */
public class ProfessorValidator {

	/**
	 * 
	 * @param students
	 * @param studentId
	 * @return
	 */
	public static boolean isValidStudent(Vector<Student> students, String studentId) {
		
		boolean result = false;
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).getUserId().equals(studentId))
				result = true;
		}
		return result;
	}
	
	/**
	 * 
	 * @param assignedCourses
	 * @param courseId
	 * @return
	 */
	public static boolean isValidCourse(Vector<Course> assignedCourses, int courseId) {

		boolean result = false;
		for(int i = 0; i < assignedCourses.size(); i++) {
			if(assignedCourses.get(i).getCourseId() == courseId)
				result= true;
		}
		return result;
	}
}
