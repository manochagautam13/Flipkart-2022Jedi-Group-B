package com.flipkart.application;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.service.PaymentServiceImplementation;
import com.flipkart.service.PaymentServiceInterface;
import com.flipkart.dao.StudentDaoImplementation;
import com.flipkart.service.StudentOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;


/*
 * Student Menu
 */

public class CrsStudentMenu {

        /*
         * Shows Student Menu and input choices
         * @param student
         * @throws SQLException
         * @throws CourseAlreadyRegisteredException
         */
        public void studentMenu(Student student) throws IOException, SQLException, CourseAlreadyRegisteredException {
            while(true) {
                System.out.println("");
                System.out.println("-----STUDENT MENU-----");
                System.out.println("1.view Details\n2.view Courses\n3.Register for Courses\n4.View Report Card\n5.Pay Fee\n6.Check Fee Status\n7.View Registered Courses\n8.Exit\n");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter the choice");
                int option = Integer.parseInt(br.readLine());
                StudentOperations studentOperations=new StudentOperations();
                StudentDaoImplementation studentDaoImplementation=new StudentDaoImplementation();
                switch (option) {
                    case 1:
                        System.out.println("Student Details -------");
                        System.out.println("Student Id: "+student.getUserId()+"\nStudent Name: "+student.getUserName()+"\nEmail Id: "+student.getEmailId()+"\nSemester: "+student.getSemester());
                        System.out.println("");
                        break;
                    case 2:
                        
                        ArrayList<Course> courses= (ArrayList<Course>) studentOperations.viewCourses();
                        
                        if (courses.size() == 0) {
                        	System.out.println("No Courses To Show!!");
                        	break;
                        }
                        
                        System.out.println("List of Courses Available");
                        System.out.println("CourseId-CourseName");
                        courses.forEach(System.out::println);
//                        for(Course c:courses)
//                            System.out.println(c.getCourseId()+"\t-\t"+c.getCourseName());
                        break;
                    case 3:
                        studentOperations.registerCourses(student.getUserId());
                        break;
                    case 4:
                        studentOperations.viewGradeCard(student.getUserId());
                        break;
                    case 5:
                        PaymentServiceInterface psi = new PaymentServiceImplementation();
                        psi.payFees(student);
                        break;
                    case 6:
                        System.out.println("Current Fee Status Says : ");
                        System.out.println(studentDaoImplementation.getfeeStatus(student.getUserId()));
                        break;
                    case 7:
                        studentOperations.registeredCourseList(student.getUserId());
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("Exit");
                }
            }
        }

    }