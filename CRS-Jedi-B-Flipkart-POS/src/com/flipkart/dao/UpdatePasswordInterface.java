package com.flipkart.dao;

import java.sql.SQLException;

public interface UpdatePasswordInterface {

    boolean updatePassword(String userId,String oldpassword,String newpassword) throws SQLException;
}
