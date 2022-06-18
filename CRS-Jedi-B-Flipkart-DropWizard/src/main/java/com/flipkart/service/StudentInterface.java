package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseAlreadyRegisteredException;

import java.sql.SQLException;
import java.util.List;

public interface StudentInterface {

    /*
     * print registered course list
     * @param studentId
     * @throws SQLException
     */
    public void registeredCourseList(String studentId) throws SQLException;

    /*
     * register courses for  given student
     * @param studentID
     * @throws SQLException
     * @throws CourseAlreadyRegisteredException
     */
    public boolean registerCourses(String studentID, int course) throws SQLException, CourseAlreadyRegisteredException;

    /*
     * view grade card of given student
     * @param studentId
     * @throws SQLException
     */
    void viewGradeCard(String studentId) throws SQLException;

    /*
     * view courses
     * @return list of courses
     * @throws SQLException
     */
    public List<Course> viewCourses() throws SQLException;
}

