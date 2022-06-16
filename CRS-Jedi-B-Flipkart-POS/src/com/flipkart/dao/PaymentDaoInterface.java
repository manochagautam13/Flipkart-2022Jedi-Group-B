package com.flipkart.dao;

import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface PaymentDaoInterface {
    void insertIntoPayment(String paymentId, String paymentType) throws SQLException;
    void insertIntoBookkeeper(String paymentId, String paymentType, int semester) throws SQLException;
    void updateFeeStatus(String studentId) throws SQLException;
	boolean checkPaid(String userId, int semester);
}
