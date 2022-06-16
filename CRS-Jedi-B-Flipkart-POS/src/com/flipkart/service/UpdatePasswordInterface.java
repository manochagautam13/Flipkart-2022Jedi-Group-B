package com.flipkart.service;

import com.flipkart.exception.OldPasswordNotValidException;

import java.sql.SQLException;

public interface UpdatePasswordInterface {
    /*
     * update password
     * @throws OldPasswordNotValidException
     */
    void updatePassword() throws OldPasswordNotValidException;
}
