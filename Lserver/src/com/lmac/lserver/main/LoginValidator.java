package com.lmac.lserver.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lmac.lserver.utils.Log;

public class LoginValidator {

	Connection conn = null;

	public LoginValidator() {
		this.conn = SQLLoader.getConnection();
	}

	public int validate(String data) {
		Log.print("Validating for string: " + data);
		String[] loginInfo = data.split("-");
		String user = loginInfo[1].trim();
		String password = loginInfo[2].trim();
		int charID = Integer.parseInt(loginInfo[3].trim());

		try {

			PreparedStatement stmt;
			
			String query = "SELECT password FROM accounts WHERE username=?";
			if (conn == null) {
				Log.error("SQL connection == null");
			}
			stmt = conn.prepareStatement(query);
			stmt.setString(1, user);

			ResultSet rs = stmt.executeQuery();
			String pwCheck = "";
			
			while (rs.next()) {
				pwCheck = rs.getString("password");
				
			}

			if (pwCheck.trim().equals(password)) {
				Log.print("Password Verified");
				return charID;
			} else {
				Log.print("Password Check Failed");
				return 0;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;

	}

}
