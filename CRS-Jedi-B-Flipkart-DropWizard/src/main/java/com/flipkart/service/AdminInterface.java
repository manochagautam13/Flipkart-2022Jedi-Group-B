package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

public interface AdminInterface {
    /*
     * Add Professor to the database
     * @param professor
     */
    public void addProfessor(Professor professor);

    /*
     * Add Course to the database
     * @param course
     */
    public void addCourse(Course course);

    /*
     * Remove course from the database
     * @param courseId
     */
    public void dropCourse(int courseId);


    boolean approveStudents(String studentId) throws Exception;


    void registerCourse(String studentId, int courseId) throws Exception;

    /*
     * Show courses
     * @throws CourseNotFound Exception
     */
    public ArrayList<Course> viewCourses() throws Exception;
//    public void generateReportCard(String studentId);
}
