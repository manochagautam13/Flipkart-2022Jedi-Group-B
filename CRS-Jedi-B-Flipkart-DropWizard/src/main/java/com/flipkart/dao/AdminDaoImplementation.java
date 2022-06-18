package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;
//import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

class pair{
	String s;
	int c;
	public pair(String s, int c){
		this.s = s;
		this.c = c;
	};
}

public class AdminDaoImplementation implements AdminDaoInterface{

//    final org.apache.log4j.Logger logger = Logger.getLogger(AdminDaoImplementation.class);

    private static volatile AdminDaoImplementation instance = null;
    public AdminDaoImplementation() {}
    public static AdminDaoImplementation getInstance() {
        if (instance == null) {
            synchronized (AdminDaoImplementation.class) {
                instance = new AdminDaoImplementation();
            }
        }
        return instance;
    }

    @Override
    public boolean addProfessor(Professor professor) {
        boolean ok = true;
        try{
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            if(con==null)System.out.println("connection not established");
                PreparedStatement preparedStatement = con.prepareStatement(SQLQueriesConstants.ADD_USER_QUERY);
                preparedStatement.setString(1, professor.getUserId());
                preparedStatement.setString(2, professor.getPassword());
                preparedStatement.setString(3, professor.getUserName());
                preparedStatement.setString(4, professor.getEmailId());
                preparedStatement.setString(5, professor.getContactNo());
                preparedStatement.setInt(6, 2);

                int rows = preparedStatement.executeUpdate();

                PreparedStatement preparedStatement1 = con.prepareStatement(SQLQueriesConstants.ADD_PROFESSOR_QUERY);
                preparedStatement1.setString(1, professor.getUserId());
                preparedStatement1.setString(2, professor.getAreaOfExpertise());
                preparedStatement1.setInt(3, professor.getYearsOfExperience());
                int rowsAffected1 = preparedStatement1.executeUpdate();

                if (rowsAffected1 == 1 && rows == 1) {
                    ok=true;
                }
            }
         catch (SQLException e) {
            ok = false;
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
        return ok;
    }

    public boolean validateCredentials(String adminId, String password){
        try{
            Connection conn = DBUtils.getConnection();

            // String sql = "SELECT * FROM user, admin where userId like ? and adminId like ? and user.password like  ?";
//            String sql = "select * from user where userid="+studentId+" and password="+password;
            PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.VALIDATE_ADMIN_CREDENTIALS);
            statement.setString(1,adminId);
            statement.setString(2,adminId);
            statement.setString(3,password);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
        return false;
    }
    @Override
    public boolean addCourse(Course course) {
        boolean ok = true;
        try{
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            if(con==null)System.out.println("connection not established");
            String sql = "insert into course values(" + course.getCourseId() + ", '" + course.getCourseName()+ "')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            ok = false;
            System.out.println("The Course Id already exists!");
//            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public boolean dropCourse(int courseId) {
        boolean ok = true;
        try{
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            if(con==null)System.out.println("connection not established");
            String sql = "DELETE FROM course WHERE courseId= " + courseId;
            int rs = stmt.executeUpdate(sql);
            
            if (rs == 0) {
            	
        		System.out.println("No Such Course Exists!!");
        		ok = false;
        	
            }
            
        } catch (SQLException e) {
            ok = false;
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return ok;
    }



    public boolean isApproved(String studentId) throws Exception{
        Connection con = DBUtils.getConnection();
        // String sql = "select * from student where studentId=? and isApproved = 1";
        PreparedStatement stmt = con.prepareStatement(SQLQueriesConstants.GET_APPROVED_STUDENTS);
        stmt.setString(1,studentId);
        ResultSet rs =  stmt.executeQuery();
        while(rs.next()) {
            return true;
        }
        return false;
    }
    @Override
    public boolean approveStudents(String studentId) throws Exception {
            String id = studentId;
            // String sql1 = "UPDATE student SET isApproved = 1 where studentId = ?";
            Connection con = DBUtils.getConnection();
            PreparedStatement statement = con.prepareStatement(SQLQueriesConstants.APPROVE_STUDENT);
            statement.setString(1,id);
            return (statement.executeUpdate()!=0);
    }
    @Override
    public void registerCourse(String std, int course) throws Exception{
    	
    	Scanner sc = new Scanner(System.in);
    	
    	String studentId;
    	int courseId;
    	
    	int flag = 0;
    	

        ArrayList<String> studentList = new ArrayList<String>();
        ArrayList<pair> studentCourseList = new ArrayList<pair>();

        Connection con = DBUtils.getConnection();

        // String getStudents = "select distinct userId from registrar where registered = false";
        PreparedStatement stmt1 = con.prepareStatement(SQLQueriesConstants.GET_STUDENTS);

        ResultSet rs = stmt1.executeQuery();

        while(rs.next()) {
            studentId = rs.getString(1);

            // String checkCourses = "select count(*) from registrar where registered = true and userId = ?";
            stmt1 = con.prepareStatement(SQLQueriesConstants.CHECK_COURSES);
            stmt1.setString(1, studentId);

            ResultSet count = stmt1.executeQuery();
            if (count.next()) {
                if (count.getInt(1) < 4) {
                    studentList.add(studentId);
                }
            }
        }



        for (String student : studentList) {

            // String getCourseStudent = "select courseId, userId from registrar where registered = false and userId = ?";

            stmt1 = con.prepareStatement(SQLQueriesConstants.GET_COURSES_STUDENT);
            stmt1.setString(1, student);

            rs = stmt1.executeQuery();

            while(rs.next()) {
                studentCourseList.add(new pair(rs.getString(2),rs.getInt(1)));
            }

        }

        if (studentCourseList.size() == 0) {
            System.out.println("No Pending Requests!!");
            return;
        }


        System.out.println("Student ID\t-\tCourse ID");

        for (pair sc1:studentCourseList)
            System.out.println(sc1.s+"\t-\t"+sc1.c);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");


        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");



        flag = 0;

        for(pair scl:studentCourseList) {

//	    		System.out.println(scl.s+" "+studentId+" "+scl.c+" "+courseId);

            if (scl.s.equals(std) && scl.c == course) {
                // String sql = "update registrar set registered = true where courseId = ? and userId = ?;";

                PreparedStatement stmt = con.prepareStatement(SQLQueriesConstants.REGISTER_STUDENT_TO_COURSE);
                stmt.setString(2, std);
                stmt.setInt(1, course);
                stmt.executeUpdate();

                System.out.println("Student Registered!");
                flag = 1;
                break;
            }
        }





    }
//
//    @Override
//    public ArrayList<Grade> fetchGrade(int userId) {
//        return null;
//    }
	@Override
	public ArrayList<Course> viewCourses() throws SQLException {
		// TODO Auto-generated method stub
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
}
