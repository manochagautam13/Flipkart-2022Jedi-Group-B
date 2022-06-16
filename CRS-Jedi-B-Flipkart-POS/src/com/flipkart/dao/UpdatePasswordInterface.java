package com.flipkart.dao;

import java.sql.SQLException;

public interface UpdatePasswordInterface {

    /*
     * update password
     * @param userId
     * @param oldpassword
     * @param newpassword
     * @return
     * @throws SQLException
     */
    boolean updatePassword(String userId,String oldpassword,String newpassword) throws SQLException;
}
