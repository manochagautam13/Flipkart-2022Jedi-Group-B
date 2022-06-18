package com.flipkart.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

public interface AdminDaoInterface {
    default boolean addProfessor(Professor professor) {
        return false;
    }

    /*
     * add course to DB using SQL commands
     * @param course
     * @return status true or false
     */
    boolean addCourse(Course course);

    /*
     * dropCourse using SQL commands from DB
     * @param courseId
     * @return
     */
    boolean dropCourse(int courseId);



    /*
     * validate credentials from DB using SQL commands
     * @param adminId
     * @param password
     * @return
     */
    boolean validateCredentials(String adminId, String password);


    /*
     * approve students from DB using SQL commands
     * @param std
     * @param course
     * @return
     */

    boolean approveStudents(String studentId) throws Exception;

    void registerCourse(String std, int course) throws Exception;

    /*
     * pull courses from DB
     * @return list of courses
     * @throws SQLException
     */
    ArrayList<Course> viewCourses() throws SQLException;

//    ArrayList<Grade> fetchGrade(int userId);
}
