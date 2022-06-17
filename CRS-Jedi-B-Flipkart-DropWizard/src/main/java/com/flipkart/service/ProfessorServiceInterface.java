package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public interface ProfessorServiceInterface {
    /*
     * verify credentials
     * @param userId
     * @param password
     * @return
     */
    public Professor validateCredentials(String userId,String password);

    /*
     * view all courses
     * @return list of courses
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<Course> viewAllCourses() throws SQLException, ClassNotFoundException;

    /*
     * register courses
     * @param professor
     * @throws SQLException
     * @throws IOException
     */
    public void registerCourses(Professor professor) throws SQLException, IOException;

    /*
     * view enrolled students
     * @param professor
     * @return list of students mapped to course
     * @throws SQLException
     */
    public Map<String, ArrayList<String>> viewEnrolledStudents(Professor professor) throws SQLException;

    /*
     * assign grades
     * @param professor
     * @throws SQLException
     * @throws IOException
     */
    public void assignGrades(Professor professor) throws SQLException, IOException;


}
