package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.dao.ProfessorOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.IntStream;

public class ProfessorService implements ProfessorServiceInterface {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    ProfessorOperations profOp=new ProfessorOperations();
    public Professor validateCredentials(String userId,String password){

        return profOp.validateCredentialsWithDB(userId,password);
    }
    public ArrayList<Course> viewAllCourses() throws SQLException{
        return profOp.viewCoursesWithDB();
    }
    public Map<String, ArrayList<String>> viewEnrolledStudents(String professor) throws SQLException {
        Map<String,ArrayList<String>> students=profOp.viewEnrolledStudentsWithDB(professor);
        return students;
    }
    public boolean assignGrades(String professorId, int course, String student, String grade) throws SQLException, IOException {
        Map<String,ArrayList<String>> courseWithStudents=profOp.viewEnrolledStudentsWithoutGrade(professorId);
        
        if (courseWithStudents.size() == 0) {
        	System.out.println("Not Applicable!!");
        	return false;
        }
        System.out.println("Make a report card for a student");
        System.out.println("Enter the Course Index and Students index ");
        int courseindex=1;
        for(String CourseName:courseWithStudents.keySet()){
            System.out.println(courseindex+". "+"("+CourseName+")");
            int studentsIndex=1;
            for(String std:courseWithStudents.get(CourseName)){
                System.out.println("\t"+studentsIndex+". ("+std+")");
                studentsIndex++;
            }
            courseindex++;
        }

        int courseChoice=course;

        String studentChoice=student;

        String Grade=grade;
        return profOp.provideGrade(course,student,grade);



    }



    public boolean registerCourses(String professor, int course) throws SQLException, IOException {
    	
    	
    	

    		ArrayList<Course> courses=profOp.viewAvailableCoursesWithDB(professor);
    		if (courses.size() == 0) {
            	System.out.println("No Courses To Register!!");
            	return false;
            }
//            int index=1;
//            for (Course c : courses) {
//                System.out.println(index+".\t ("+c.getCourseId() + "\t-\t" + c.getCourseName()+")");
//                index++;
//            }
            
            IntStream.range(0, courses.size()).forEach(index->System.out.println((index+1)+".\t"+courses.get(index)));
            


            int choice=course;


            return profOp.registerCoursesWithDB(professor,course);


    }

}
