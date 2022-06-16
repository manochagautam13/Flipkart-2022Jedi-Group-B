package com.flipkart.service;

import com.flipkart.bean.Student;
import com.flipkart.constants.PaymentConstants;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.dao.PaymentDaoImplementation;
import com.flipkart.dao.PaymentDaoInterface;
import com.flipkart.service.PaymentServiceInterface;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class PaymentServiceImplementation implements PaymentServiceInterface {
    @Override
    public void payFees(Student student) throws SQLException {

        // String sql="select * from registrar where registrar.userId=?";
        Connection conn = DBUtils.getConnection();
        PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.COURSES_OF_STUDENT);
        statement.setString(1,student.getUserId());
        ResultSet rs = statement.executeQuery();
        int count = 0;
        while(rs.next()) count++;

        if(count < 4) {
            System.out.println("You have not registered enough number of courses");
            return;
        }
        
        // String sql1="select * from registrar where registered = true and registrar.userId=?";
        Connection conn1 = DBUtils.getConnection();
        PreparedStatement statement1 = conn1.prepareStatement(SQLQueriesConstants.REG_COURSES_OF_STUDENT);
        statement1.setString(1,student.getUserId());
        ResultSet rs1 = statement1.executeQuery();
        int count1 = 0;
        while(rs1.next()) count1++;
        
        if (count1 < 4) {
        	System.out.println("Try paying fee after the registeration process ends!");
        	return;
        }
        
        PaymentDaoInterface pdi = new PaymentDaoImplementation();
        
        boolean checkPaid = pdi.checkPaid(student.getUserId(),student.getSemester());
        if (checkPaid) {
        	System.out.println("Already Paid!!");
        	return;
        }
        System.out.println("Pay Fee");

        System.out.println("Select The payment Type");
        System.out.println("1. " + PaymentConstants.UPI_STRING);
        System.out.println("2. " + PaymentConstants.CARD_PAYMENT_STRING);
        Scanner s = new Scanner(System.in);
        int pType = s.nextInt();
        
        if(pType == 1) {
            String paymentId = this.getRandomString();
            pdi.insertIntoPayment(paymentId,PaymentConstants.UPI_STRING);
            System.out.println("Enter UPI Id:");
            String upi = s.next();
            System.out.println("Enter Pin");
            upi = s.next();
            pdi.insertIntoBookkeeper(paymentId,student.getUserId(),student.getSemester());
        }
        else if(pType == 2) {
            String paymentId = this.getRandomString();
            pdi.insertIntoPayment(paymentId,PaymentConstants.CARD_PAYMENT_STRING);
            System.out.println("Enter card-No Id:");
            String upi = s.next();
            System.out.println("Enter Expiration date:");
            upi = s.next();
            System.out.println("Enter Pin");
            upi = s.next();
            pdi.insertIntoBookkeeper(paymentId,student.getUserId(),student.getSemester());
        }
        else {
            System.out.println("Incorrect/suspicious operation !!");
            return;
        }
        pdi.updateFeeStatus(student.getUserId());
        System.out.println("Payment Successfully done !!");
    }

    public String getRandomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
        return generatedString;
    }
}
