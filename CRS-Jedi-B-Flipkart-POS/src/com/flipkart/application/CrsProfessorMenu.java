package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.service.ProfessorService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

/*
 * Proff Menu
 */

public class CrsProfessorMenu {
    ProfessorService profServ=new ProfessorService();

    /* Shows Professor menu
     * @param professor
     * @throws IOException
     * @throws SQLException
     */

    public void professorMenu(Professor professor) throws IOException, SQLException {
        while(true) {
            System.out.println("---Professor Menu-----");
            System.out.println("1.view Details\n2.view Courses\n3.Register for Courses\n4.View Enrolled Students in courses\n5.Make Report Card for a student\n6.Exit");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the choice");
            int option = Integer.parseInt(br.readLine());
            switch (option) {
                case 1:
                    System.out.println("Details");
                    System.out.println("Id: "+professor.getUserId()+"\nProfessorName: "+professor.getUserName()+"\nEmailId: "+professor.getEmailId()+"\nAreaOfExpertise: "+professor.getAreaOfExpertise()+"\nYearsOfExperience: "+professor.getYearsOfExperience());
                    break;
                case 2:
                    ArrayList<Course> courses= profServ.viewAllCourses();
                    if (courses.size()>0)System.out.println("CourseId-CourseName");
                    else System.out.println("No Courses To Show!!");
                    courses.forEach(System.out::println);
//                    for(Course c:courses)
//                        System.out.println(c.getCourseId()+"\t-\t"+c.getCourseName());
                    break;
                case 3:
                    
                    profServ.registerCourses(professor);
                    break;
                case 4:
                    
                    Map<String,ArrayList<String>> courseWithStudents=profServ.viewEnrolledStudents(professor);
                    int courseindex=1;
                    
                    if (courseWithStudents.size()==0) {
                    	System.out.println("No Students Enrolled!!");
                    	break;
                    }
                    System.out.println("View enrolled students in each course");
                    for(String CourseName:courseWithStudents.keySet()){
                        System.out.println(courseindex+". "+"("+CourseName+")");
                        int studentsIndex=1;
                        for(String student:courseWithStudents.get(CourseName)){
                            System.out.println("\t"+studentsIndex+". ("+student+")");
                            studentsIndex++;
                        }
                        courseindex++;
                    }
                    break;
                case 5:
                    
                    profServ.assignGrades(professor);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid Choice");

            }
        }
    }

}
