package com.flipkart.constants;

public class SQLQueriesConstants {

    public static final String ADD_REGISTERCOURSE_QUERY="insert into registrar values (?, ?, ?, ?)";
    public static final String ADD_PROFESSOR_QUERY="insert into professor values(?,?,?)";
    public static final String ADD_STUDENT_QUERY = "insert into student values (?, ?, ?, ?, ?)";
    public static final String ADD_USER_QUERY = "insert into user values (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_PASSWORD="update user set password = ? where userid=?";
    public static final String GET_DETAILS="select userid,password from user where userid = ? and password = ?";
    public static final String VIEW_GRADE_CARD = "select * from gradeCard where userId = ?";
    public static final String VIEW_REGISTERED_COURSES="select * from registrar where userId=? and registered = true";
    public static final String VALIDATE_ADMIN_CREDENTIALS = "SELECT * FROM user, admin where userId like ? and adminId like ? and user.password like ?";
    public static final String APPROVE_STUDENT = "UPDATE student SET isApproved = 1 where studentId = ?";
    public static final String GET_STUDENTS = "select distinct userId from registrar where registered = false";
    public static final String CHECK_COURSES = "select count(*) from registrar where registered = true and userId = ?";
    public static final String GET_COURSES_STUDENT = "select courseId, userId from registrar where registered = false and userId = ?";
    public static final String SELECT_COURSE = "SELECT * FROM course";
    public static final String GET_APPROVED_STUDENTS = "select * from student where studentId=? and isApproved = 1";
    public static final String REGISTER_STUDENT_TO_COURSE = "update registrar set registered = true where courseId = ? and userId = ?;";
    public static final String INSERT_INTO_PAYEMNT = "INSERT INTO `payment` (`paymentType`,`paymentId`) VALUES(?,?);";
    public static final String INSERT_INTO_BOOKKEEPER = "INSERT INTO `bookkeeper` (`paymentId`,`StudentID`,`semester`) VALUES(?,?,?);";
    public static final String UPDATE_FEE_STATUS = "UPDATE `student` SET `feeStatus` = ? WHERE `studentId` = ?;";
    public static final String CHECK_PAID = "select count(*) from bookkeeper where studentId = ? and semester = ?";
    public static final String COURSES_OF_STUDENT = "select * from registrar where registrar.userId=?";
    public static final String REG_COURSES_OF_STUDENT = "select * from registrar where registered = true and registrar.userId=?";
    public static final String VIEW_ENROLLED = "select registrar.userId,user.userName,course.courseId,course.courseName from registrar,user,course where registrar.courseId in(select courseId from professorreg where professorreg.userId=? ) and registrar.userId=user.userId and registrar.courseId=course.courseId ";
    public static final String PROVIDE_GRADE = "UPDATE registrar set grade=? where userId=? and courseId=?";
    public static final String REGISTERED_COURSES = "INSERT INTO professorreg(userId,courseId) VALUES(?,?)";
    public static final String AVAILABLE_COURSES = "select courseId,courseName from course where courseId not in (select courseId from professorReg)";
    public static final String GET_STUDENT =  "SELECT * FROM student where studentId=?";
    public static final String GET_USER = "SELECT * FROM user where userId=?";
    public static final String VALIDATE_CRED = "SELECT * FROM user where userid = ? and password = ?";
    public static final String GET_FEE_STATUS = "SELECT paymentId FROM bookkeeper where studentId=?";
    public static final String SELECT_COURSEID = "select courseId from professorreg where courseId = ?"
    public static final String COURSE_DETAILS = "SELECT * FROM course where courseId=?";
    public static final String VIEW_GRADES = "SELECT * FROM registrar where userId=? and grade between 'A' and 'F'";
}
