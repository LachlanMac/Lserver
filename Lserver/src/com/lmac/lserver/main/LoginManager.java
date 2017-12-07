package com.lmac.lserver.main;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lmac.lserver.main.SQLLoader;
import com.lmac.lserver.utils.Log;


public class LoginManager {
	
	Connection conn = null;
	
	public LoginManager(){
		
		this.conn = SQLLoader.getConnection();
		
	}
	
	public boolean login(String user, String password){
		String pwCheck = "";
		
		try {
			
			PreparedStatement stmt;
			
			String query = "SELECT password FROM accounts WHERE user=?";	
			if(conn == null){
				Log.error("SQL connection == null");
			}
			stmt = conn.prepareStatement(query);
			stmt.setString(1, user);
			
			
			ResultSet rs = stmt.executeQuery();
			 while (rs.next()) {
		           pwCheck = rs.getString("password");
		        }
			 
			 if(pwCheck.trim().equals(password)){
				 return true;
			 }else{
				 return false;
			 }
			 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
		
		
		
		
		
	}
}
