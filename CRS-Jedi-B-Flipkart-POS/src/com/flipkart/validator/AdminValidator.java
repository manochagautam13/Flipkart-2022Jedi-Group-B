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
public class AdminValidator {

	/**
	 * 
	 * @param newCourse
	 * @param courseList
	 * @return 
	 */
	public static boolean isValidNewCourse(Course newCourse, Vector<Course> courseList) {
		
		for(Course course : courseList) {
			if(newCourse.getCourseId() == course.getCourseId()) {
				return false; 
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param dropCourseId
	 * @param courseList
	 * @return 
	 */
	public static boolean isValidDropCourse(int dropCourseId, Vector<Course> courseList) {
		
		for(Course course : courseList) {
			if(dropCourseId == course.getCourseId()) {
				return true; 
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param studentId
	 * @param studentList
	 * @return 
	 */
	public static boolean isValidUnapprovedStudent(String studentId, Vector<Student> studentList) {
		
		for(Student student : studentList) {
			if(studentId.equals(student.getUserId())) {
				return true;
			}
		}
		return false;
	}
}
