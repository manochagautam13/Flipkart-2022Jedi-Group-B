/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

/**
 * @author gautam.manocha
 *
 */
public class GeneralLoginDaoImplementation implements GeneralLoginDaoInterface{

	private static volatile GeneralLoginDaoImplementation instance = null;
    public GeneralLoginDaoImplementation() {}
    public static GeneralLoginDaoImplementation getInstance() {
        if (instance == null) {
            synchronized (AdminDaoImplementation.class) {
                instance = new GeneralLoginDaoImplementation();
            }
        }
        return instance;
    }
	
	@Override
	public int getUserType(String userId) {
		// TODO Auto-generated method stub
		try{
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            if(con==null)System.out.println("connection not established");
                PreparedStatement preparedStatement = con.prepareStatement("select role from user where userid = ?");
                preparedStatement.setString(1, userId);

                ResultSet rows = preparedStatement.executeQuery();

                if (rows.next()) {
                	return rows.getInt(1);
                }
                else {
                	return 0;
                }
            }
         catch (SQLException e) {
            
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        

		return 0;
	}

}
