package com.flipkart.service;

import com.flipkart.bean.Student;

import java.sql.SQLException;

public interface PaymentServiceInterface {
    /*
     * Payfees for given student
     * @param student
     * @param semester
     * @throws SQLException
     */

    void payFees(String student, int semester) throws SQLException;
}
