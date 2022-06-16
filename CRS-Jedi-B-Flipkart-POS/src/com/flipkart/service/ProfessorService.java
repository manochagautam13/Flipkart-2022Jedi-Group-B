package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.dao.ProfessorOperations;
import com.flipkart.service.ProfessorServiceInterface;

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
    public Map<String, ArrayList<String>> viewEnrolledStudents(Professor professor) throws SQLException {
        Map<String,ArrayList<String>> students=profOp.viewEnrolledStudentsWithDB(professor);
        return students;
    }
    public void assignGrades(Professor professor) throws SQLException, IOException {
        Map<String,ArrayList<String>> courseWithStudents=profOp.viewEnrolledStudentsWithDB(professor);
        
        if (courseWithStudents.size() == 0) {
        	System.out.println("Not Applicable!!");
        	return;
        }
        System.out.println("Make a report card for a student");
        System.out.println("Enter the Course Index and Students index ");
        int courseindex=1;
        for(String CourseName:courseWithStudents.keySet()){
            System.out.println(courseindex+". "+"("+CourseName+")");
            int studentsIndex=1;
            for(String student:courseWithStudents.get(CourseName)){
                System.out.println("\t"+studentsIndex+". ("+student+")");
                studentsIndex++;
            }
            courseindex++;
        }
        System.out.println("Pick course Id");
        int courseChoice=Integer.parseInt(br.readLine());
        System.out.println("Pick student Id");
        String studentChoice=br.readLine();
        System.out.println("Enter the grade between (A-F)");
        String Grade=br.readLine();
        profOp.provideGrade(courseChoice,studentChoice,Grade);



    }
 
    public void registerCourses(Professor professor) throws SQLException, IOException {
    	
    	
    	
    	while(true) {
    		ArrayList<Course> courses=profOp.viewAvailableCoursesWithDB(professor);
    		if (courses.size() == 0) {
            	System.out.println("No Courses To Register!!");
            	return;
            }
//            int index=1;
//            for (Course c : courses) {
//                System.out.println(index+".\t ("+c.getCourseId() + "\t-\t" + c.getCourseName()+")");
//                index++;
//            }
            
            IntStream.range(0, courses.size()).forEach(index->System.out.println((index+1)+".\t"+courses.get(index)));
            
            System.out.println("Register for the courses");
            System.out.println("---Enter the Index which you want to register(Enter 0 to exit)");
            System.out.println("Index." +"CourseName-CourseId");

            int choice=Integer.parseInt(br.readLine());
            if(choice==0){
                break;
            }
            else{
                if((choice-1)<courses.size())
                profOp.registerCoursesWithDB(professor,courses.get(choice-1));
                else
                    System.out.println("Enter Correct index number");
            }
        }
    }

}
