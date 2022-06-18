package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public interface ProfessorUtilsInterface {
    /*
     * verify credentials with DB
     * @param userId
     * @param password
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Professor validateCredentialsWithDB(String userId,String password) throws ClassNotFoundException, SQLException;

    /*
     * get courses list from DB
     * @return list of courses
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<Course> viewCoursesWithDB() throws SQLException, ClassNotFoundException;

    /*
     * register courses in DB
     * @param professor
     * @param course
     * @throws SQLException
     */

    public boolean registerCoursesWithDB(String professor, int course) throws SQLException;

    /*
     * view list of available courses
     * @param professor
     * @return list of courses
     * @throws SQLException
     */
    public ArrayList<Course> viewAvailableCoursesWithDB(String professor) throws SQLException ;

    /*
     * view list of students in each course
     * @param professor
     * @return list of students mapped to course
     * @throws SQLException
     */
    public Map<String, ArrayList<String>> viewEnrolledStudentsWithDB(String professor) throws SQLException;

    /*
     * set grade for given student in given subject
     * @param courseId
     * @param studentId
     * @param Grade
     * @throws SQLException
     */
    public boolean provideGrade(int courseId, String studentId, String Grade) throws SQLException;


}
