package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyRegisteredException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDaoInterface
{
    String addStudent() throws SQLException, ClassNotFoundException;

    Student getStudent(String studentId) throws SQLException;

    Student validateCredentials(String studentId, String password);

    String getfeeStatus(String studentId) throws SQLException;

    ArrayList<Integer> registeredCoursesList(String studentId) throws SQLException;

    void registerCourses(String studentId,ArrayList<Integer> courses) throws SQLException, CourseAlreadyRegisteredException;

    ArrayList<Course> viewCourses() throws SQLException;

    Course viewCourse(int courseId) throws SQLException;

    String removeStudent(String studentId) throws SQLException;

    ArrayList<GradeCard> viewGrades(String studentId) throws SQLException;

}
