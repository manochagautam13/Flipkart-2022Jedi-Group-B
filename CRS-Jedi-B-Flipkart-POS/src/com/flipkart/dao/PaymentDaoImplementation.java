package com.flipkart.dao;

import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDaoImplementation implements PaymentDaoInterface{
    @Override
    public void insertIntoPayment(String paymentId, String paymentType) throws SQLException {
        String sql = "INSERT INTO `payment`\n" +
                "(`paymentType`,\n" +
                "`paymentId`)\n" +
                "VALUES\n" +
                "(?,\n" +
                "?);\n";
        Connection conn = DBUtils.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,paymentType);
        statement.setString(2,paymentId);
        statement.executeUpdate();
    }

    @Override
    public void insertIntoBookkeeper(String paymentId, String studentId, int semester) throws SQLException {
        String sql = "INSERT INTO `bookkeeper`\n" +
                "(`paymentId`,\n" +
                "`StudentID`,\n" +
                "`semester`)\n" +
                "VALUES\n" +
                "(?,\n" +
                "?,\n" +
                "?);\n";
        Connection conn = DBUtils.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,paymentId);
        statement.setString(2,studentId);
        statement.setInt(3,semester);
        statement.executeUpdate();
    }

    @Override
    public void updateFeeStatus(String studentId) throws SQLException {
        String sql = "UPDATE `student`\n" +
                "SET\n" +
                "`feeStatus` = ?\n" +
                "WHERE `studentId` = ?;";
        Connection conn = DBUtils.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,studentId);
        statement.setString(2,"1");
        statement.executeUpdate();
    }
}
