package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.dao.AdminDaoImplementation;
import com.flipkart.dao.AdminDaoInterface;

public class AdminOperation implements AdminInterface {
    private static volatile AdminOperation instance = null;

    // private constructor
    private AdminOperation() {
    }

    public static AdminOperation getInstance() {
        if (instance == null) {
            synchronized (AdminOperation.class) {
                instance = new AdminOperation();
            }
        }
        return instance;
    }

    @Override
    public void addProfessor(Professor professor) {
        AdminDaoInterface admin = AdminDaoImplementation.getInstance();
        boolean ok = admin.addProfessor(professor);
        if(ok) {
            System.out.println("Professor added");
            System.out.println("+++++++++++++++++++++++");
        }
        else {
            System.out.println("Professor not added");
        }
    }

    @Override
    public void addCourse(Course course){
        AdminDaoInterface admin = AdminDaoImplementation.getInstance();
        boolean ok = admin.addCourse(course);
        if(ok) {
            System.out.println("Course added");
            System.out.println("+++++++++++++++++++++++");
        }
        else {
            System.out.println("Course not added");
        }

    }

    @Override
    public void dropCourse(int courseId){
        AdminDaoInterface admin = AdminDaoImplementation.getInstance();
        boolean ok = admin.dropCourse(courseId);
        if(ok) {
            System.out.println("Course Dropped");
            System.out.println("+++++++++++++++++++++++");
        }
        else {
            System.out.println("Cant drop course");
        }

    }

    @Override
    public boolean approveStudents() {
        AdminDaoInterface admin = AdminDaoImplementation.getInstance();
        boolean ok = admin.approveStudents();
        if(ok) {
            System.out.println("");
            System.out.println("+++++++++++++++++++++++");
            return true;
        }
        else {
            System.out.println("Cant drop course");
            return false;
        }
    }
    
    @Override
    public void registerCourse() throws Exception {
    	try {
    		
	    		AdminDaoInterface admin = AdminDaoImplementation.getInstance();
	    		admin.registerCourse();
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    }

	@Override
	public Boolean viewCourses() throws Exception {
		// TODO Auto-generated method stub
		AdminDaoImplementation adminDaoImplementation = new AdminDaoImplementation();
		
		ArrayList<Course> courses = adminDaoImplementation.viewCourses();
		
		if (courses.size() == 0) {
			System.out.println("No Courses To Show!!");
			return false;
		}
		System.out.println("Course IDs - Course Names");
		for (Course c: courses) {
			System.out.println(c.getCourseId()+" - "+c.getCourseName());
		}
		return true;
	}

//    @Override
//    public void generateReportCard(String studentId) {
//
//    }
}
