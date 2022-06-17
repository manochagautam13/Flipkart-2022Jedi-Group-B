package com.flipkart.service;

import com.flipkart.bean.Student;

import java.sql.SQLException;

public interface PaymentServiceInterface {
    /*
     * Payfees for given student
     * @param student
     * @throws SQLException
     */
    void payFees(Student student) throws SQLException;
}
