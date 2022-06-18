package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyRegisteredException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDaoInterface
{
    /*
     * add student in DB
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    boolean addStudent(Student student) throws SQLException, ClassNotFoundException;

    /*
     * get student from student id in DB
     * @param studentId
     * @return
     * @throws SQLException
     */
    Student getStudent(String studentId) throws SQLException;

    /*
     * verify credentials from DB
     * @param studentId
     * @param password
     * @return
     */
    Student validateCredentials(String studentId, String password);

    /*
     * get fee status from DB
     * @param studentId
     * @return
     * @throws SQLException
     */
    String getfeeStatus(String studentId) throws SQLException;

    /*
     * get registered course list from DB
     * @param studentId
     * @return lis of courses
     * @throws SQLException
     */
    ArrayList<Integer> registeredCoursesList(String studentId) throws SQLException;


    /*
     * register course for given student from given set of courses
     * @param studentId
     * @param courses
     * @throws SQLException
     * @throws CourseAlreadyRegisteredException
     */
    boolean registerCourses(String studentId,int courses) throws SQLException, CourseAlreadyRegisteredException;


    /*
     * view courses from DB
     * @return
     * @throws SQLException
     */
    ArrayList<Course> viewCourses() throws SQLException;


    /*
     * view specified course
     * @param courseId
     * @return
     * @throws SQLException
     */
    Course viewCourse(int courseId) throws SQLException;


    /*
     * remove specifies student from DB
     * @param studentId
     * @return
     * @throws SQLException
     */
    String removeStudent(String studentId) throws SQLException;


    /*
     * view grades for each subject for given student from DB
     * @param studentId
     * @return
     * @throws SQLException
     */
    ArrayList<GradeCard> viewGrades(String studentId) throws SQLException;

}
