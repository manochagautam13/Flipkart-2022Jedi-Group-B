package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;

import java.util.Scanner;

/*
    Menu for Admin
*/

public class AdminMenu {
    /*
     * displays admin menu
     * take choice input
     */
    public void adminMenu(){

        int choice;
        int d=1;
        while(d!=0) {
            System.out.println("Enter your choice : ");
            System.out.println("1. Add Professor");
            System.out.println("2. View Courses");
            System.out.println("3. Add Course");
            System.out.println("4. Drop Course");
            System.out.println("5. Approve Pending Students");
            System.out.println("6. Register For Courses");
            System.out.println("7. Exit");
            Scanner in= new Scanner(System.in);

            choice = in.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("Enter Prof ID");
                    String profId = in.next();
                    System.out.println("Name:");
                    String name = in.next();
                    System.out.println("Professor Email id ");
                    String email = in.next();
                    System.out.println("Password: ");
                    String password = in.next();
                    System.out.println("Professor Contact number");
                    String contact = in.next();
                    System.out.println("Area of expertise");
                    String areaOfExpertise = in.next();
                    System.out.println("Years of experience");
                    int yoe = in.nextInt();
                    Professor p = new Professor();
                    p.setUserId(profId);
                    p.setUserName(name);
                    p.setEmailId(email);
                    p.setPassword(password);
                    p.setContactNo(contact);
                    p.setAreaOfExpertise(areaOfExpertise);
                    p.setYearsOfExperience(yoe);
                    AdminInterface admin0 = AdminOperation.getInstance();

                    try{
                        admin0.addProfessor(p);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    AdminInterface admin2= AdminOperation.getInstance();

                    try{
                    	Boolean b = admin2.viewCourses();
                    } catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                
                case 3:
                    System.out.println("Enter Course ID");
                    int courseId = in.nextInt();
                    System.out.println("Course Name:");
                    String courseName = in.next();
                    Course c = new Course();
                    c.setCourseId(courseId);
                    c.setCourseName(courseName);
                    AdminInterface admin1 = AdminOperation.getInstance();




                    try{
                        admin1.addCourse(c);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;



                case 4:
                    admin2= AdminOperation.getInstance();

                    try{
                    	
                    	Boolean b = admin2.viewCourses();
                    	if (b) {
                    		System.out.println("Enter Course ID");
                            int cId = in.nextInt();
                    		admin2.dropCourse(cId);
                    	}
                    	else System.out.println("Cannot Drop!!");
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    AdminInterface admin3= AdminOperation.getInstance();
                    try{
                        admin3.approveStudents();
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;

                case 6:
                	AdminInterface admin4= AdminOperation.getInstance();
                	try {
                		admin4.registerCourse();
                	} catch(Exception e) {
                		System.out.println(e);
                	}
                	break;
                    
                case 7:
                    System.out.println("ok bye");
                    d=0;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
