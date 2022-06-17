package com.flipkart.dao;

import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface PaymentDaoInterface {
    /*
     * Update payment table by inserting new transaction
     * @param paymentId
     * @param paymentType
     * @throws SQLException
     */
    void insertIntoPayment(String paymentId, String paymentType) throws SQLException;
    /*
     * Update bookkeeper table
     * @param paymentId
     * @param paymentType
     * @param semester
     * @throws SQLException
     */
    void insertIntoBookkeeper(String paymentId, String paymentType, int semester) throws SQLException;
    /*
     * update fee status in table
     * @param studentId
     * @throws SQLException
     */
    void updateFeeStatus(String studentId) throws SQLException;
    /*
     * check paid status from DB
     * @param userId
     * @param semester
     * @return
     */
    boolean checkPaid(String userId, int semester);
}
