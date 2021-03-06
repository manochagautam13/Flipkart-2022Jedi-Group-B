package com.flipkart.dao;

import com.flipkart.application.CrsApplication;
import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.utils.DBUtils;
//import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDaoImplementation implements StudentDaoInterface {

//    final org.apache.log4j.Logger logger = Logger.getLogger(StudentDaoImplementation.class);
    @Override
    public String addStudent() throws SQLException {
        Connection connection = DBUtils.getConnection();
        if(connection==null)System.out.println("connection not established");

        Statement stmt = connection.createStatement();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter userId:");
        String userId=sc.next();
        System.out.println("Enter password:");
        String password= sc.next();
        System.out.println("Enter userName:");
        String studentName= sc.next();
        System.out.println("Enter emaiId:");
        String emaiId= sc.next();
        System.out.println("Enter contactNo:");
        String contactNo= sc.next();
        System.out.println("Enter semester:");
        int semester=sc.nextInt();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.ADD_USER_QUERY);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, studentName);
            preparedStatement.setString(4, emaiId);
            preparedStatement.setString(5, contactNo);
            preparedStatement.setInt(6, 1);

            int rows = preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 = connection.prepareStatement(SQLQueriesConstants.ADD_STUDENT_QUERY);
            preparedStatement1.setString(1, userId);
            preparedStatement1.setInt(2, semester);
            preparedStatement1.setString(3, " NA ");
            preparedStatement1.setInt(4, 0);
            preparedStatement1.setInt(5, 0);
            int rowsAffected1 = preparedStatement1.executeUpdate();
            if (rowsAffected1 == 1 && rows == 1) {
                System.out.println("Student is registered");
            }
        }
        catch(SQLException e)
        {
//            logger.info("Student with the ID exists. Try Again!!");
        }
        return null;
    }

    @Override
    public Student getStudent(String studentId) throws SQLException {
        Connection conn = DBUtils.getConnection();
        // String sql = "SELECT * FROM student where studentId=?";
        PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.GET_STUDENT);
        statement.setString(1,studentId);
        ResultSet rs = statement.executeQuery();
        // String sql1 = "SELECT * FROM user where userId=?";
        PreparedStatement statement1 = conn.prepareStatement(SQLQueriesConstants.GET_USER);
        statement1.setString(1,studentId);
        ResultSet rs1 = statement1.executeQuery();
        while(rs.next()&& rs1.next())
        {
            Student student=new Student(studentId,rs1.getString(3),rs1.getString(4), rs1.getString(2),rs1.getString(5),studentId,rs.getInt(2),rs.getString(3),rs.getString(4), rs.getBoolean(5));
            return student;
        }
        return null;
    }

    public Student validateCredentials(String studentId, String password){
        try{
            Connection conn = DBUtils.getConnection();
            // String sql = "SELECT * FROM user where userid = ? and password = ?";
            PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.VALIDATE_CRED);
            statement.setString(1,studentId);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Student student= getStudent(studentId);
                //  Student student=new Student(studentId,rs1.getString(3),rs1.getString(4), rs1.getString(2),rs1.getString(5),studentId,rs.getInt(2),rs.getString(3),rs.getString(4),true);
                return student;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public String getfeeStatus(String studentId) throws SQLException {
        Connection conn = DBUtils.getConnection();
        // String sql = "SELECT paymentId FROM bookkeeper where studentId=?";
        PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.GET_FEE_STATUS);
        statement.setString(1,studentId);
        ResultSet rs = statement.executeQuery();
        while(rs.next())
        {String x = "Fees Paid";
            return x;
        }
        
        // sql="select * from registrar where registrar.userId=?";
        
        statement = conn.prepareStatement(SQLQueriesConstants.COURSES_OF_STUDENT);
        statement.setString(1,studentId);
        rs = statement.executeQuery();
        int count = 0;
        while(rs.next()) count++;

        if(count < 4) {
            return "You have not registered enough number of courses";
            
        }
        
        // String sql1="select * from registrar where registered = true and registrar.userId=?";
        Connection conn1 = DBUtils.getConnection();
        PreparedStatement statement1 = conn1.prepareStatement(SQLQueriesConstants.REG_COURSES_OF_STUDENT);
        statement1.setString(1,studentId);
        ResultSet rs1 = statement1.executeQuery();
        int count1 = 0;
        while(rs1.next()) count1++;
        
        if (count1 < 4) {
        	return "Try paying fee after the registeration process ends!";
        	
        }
        
        return "Fees not paid";
    }

    @Override
    public ArrayList<Integer> registeredCoursesList(String studentId) throws SQLException {
        Connection conn = DBUtils.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(SQLQueriesConstants.VIEW_REGISTERED_COURSES);
        preparedStatement.setString(1, studentId);
        ResultSet rs=preparedStatement.executeQuery();
        ArrayList<Integer> courses=new ArrayList<>();
        while(rs.next())
        {
            courses.add(rs.getInt(2));
        }
        return courses;
    }

    @Override
    public void registerCourses(String studentId, ArrayList<Integer> courses) throws SQLException,CourseAlreadyRegisteredException {
        Connection connection = DBUtils.getConnection();
        Statement stmt = connection.createStatement();
        try{
            for(Integer course:courses) {
            	
            	PreparedStatement preparedStatement1 = connection.prepareStatement(SQLQueriesConstants.SELECT_COURSEID);
                preparedStatement1.setInt(1, course);
            	ResultSet flag = preparedStatement1.executeQuery();
            	if (flag.next() == false) {
            		System.out.println(course);
            		continue;
            	}
//            	System.out.println("hksjhahf");
            	
            	
                PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.ADD_REGISTERCOURSE_QUERY);
                preparedStatement.setString(1, studentId);
                preparedStatement.setInt(2, course);
                preparedStatement.setString(3, "0");
                preparedStatement.setBoolean(4, false);
                preparedStatement.executeUpdate();
            }
        }
        catch (Exception e){
        	System.out.println(e);
//            throw new CourseAlreadyRegisteredException();
        }

    }

    @Override
    public ArrayList<Course> viewCourses() throws SQLException {
        ArrayList<Course> courses=new ArrayList<Course>();
        Connection conn = DBUtils.getConnection();
        // String sql = "SELECT * FROM course";
        PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.SELECT_COURSE);
        ResultSet rs = statement.executeQuery();
        while(rs.next())
        {
          Course course=new Course();
          course.setCourseId(rs.getInt(1));
          course.setCourseName(rs.getString(2));
          courses.add(course);
        }
        return courses;
    }

    @Override
    public Course viewCourse(int courseId) throws SQLException {
        ArrayList<Course> courses=new ArrayList<Course>();
        Connection conn = DBUtils.getConnection();
        // String sql = "SELECT * FROM course where courseId=?";
        PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.COURSE_DETAILS);
        statement.setInt(1,courseId);
        ResultSet rs = statement.executeQuery();
        while(rs.next())
        {
            Course course=new Course();
            course.setCourseId(rs.getInt(1));
            course.setCourseName(rs.getString(2));
            return course;
        }
        return null;
    }

    @Override
    public String removeStudent(String studentId) throws SQLException {

        boolean st = true;
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            String sql = "delete from student where studentId = " + studentId;
        int rowsAffected = stmt.executeUpdate(sql);
        if (rowsAffected == 1) {
            return "Student Removed!";
        }
        return null;
    }

    @Override
    public ArrayList<GradeCard> viewGrades(String studentId) throws SQLException {
    ArrayList<GradeCard> gradeCards=new ArrayList<>();
        Connection conn = DBUtils.getConnection();
        // String sql = "SELECT * FROM registrar where userId=? and grade between 'A' and 'F'";
        PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.VIEW_GRADES);
        statement.setString(1, studentId);
        ResultSet rs = statement.executeQuery();
        
        int cnt = 0;
        
        while(rs.next())
        {
        	cnt++;
        	
            GradeCard g=new GradeCard(rs.getString(1), rs.getInt(2),rs.getString(3));
            gradeCards.add(g);
        }
        
        if (cnt!=4) return null;
        
        return gradeCards;
    }
}
