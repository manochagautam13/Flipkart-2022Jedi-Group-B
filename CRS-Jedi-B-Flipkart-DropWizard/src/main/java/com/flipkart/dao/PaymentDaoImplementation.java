package com.flipkart.dao;

import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDaoImplementation implements PaymentDaoInterface{
    @Override
    public void insertIntoPayment(String paymentId, String paymentType) throws SQLException {
        // String sql = "INSERT INTO `payment` (`paymentType`,`paymentId`) VALUES(?,?);";
        Connection conn = DBUtils.getConnection();
        PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.INSERT_INTO_PAYEMNT);
        statement.setString(1,paymentType);
        statement.setString(2,paymentId);
        statement.executeUpdate();
    }

    @Override
    public void insertIntoBookkeeper(String paymentId, String studentId, int semester) throws SQLException {
        // String sql = "INSERT INTO `bookkeeper` (`paymentId`,`StudentID`,`semester`) VALUES(?,?,?);";
        Connection conn = DBUtils.getConnection();
        PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.INSERT_INTO_BOOKKEEPER);
        statement.setString(1,paymentId);
        statement.setString(2,studentId);
        statement.setInt(3,semester);
        statement.executeUpdate();
    }

    @Override
    public void updateFeeStatus(String studentId) throws SQLException {
        // String sql = "UPDATE `student` SET `feeStatus` = ? WHERE `studentId` = ?;";
        Connection conn = DBUtils.getConnection();
        PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.UPDATE_FEE_STATUS);
        statement.setString(1,studentId);
        statement.setString(2,"1");
        statement.executeUpdate();
    }

	@Override
	public boolean checkPaid(String userId, int semester) {
		// TODO Auto-generated method stub
		// String sql = "select count(*) from bookkeeper where studentId = ? and semester = ?";
        Connection conn;
		try {
			conn = DBUtils.getConnection();
			PreparedStatement statement = conn.prepareStatement(SQLQueriesConstants.CHECK_PAID);
	        statement.setString(1,userId);
	        statement.setInt(2,semester);
	        ResultSet rs = statement.executeQuery();
	        
	        if (rs.next()) {
	        	if (rs.getInt(1) == 0) {
	        		return false;
	        	}
	        }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
        
        
        
		return true;
	}
}
