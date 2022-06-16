package com.flipkart.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface AdminDaoInterface {
    default boolean addProfessor(Professor professor) {
        return false;
    }
    boolean addCourse(Course course);
    boolean dropCourse(int courseId);
    boolean approveStudents();
    boolean validateCredentials(String adminId, String password);
    void registerCourse() throws Exception;
    ArrayList<Course> viewCourses() throws SQLException;

//    ArrayList<Grade> fetchGrade(int userId);
}
