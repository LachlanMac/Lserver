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

	public boolean validate(String data) {
		Log.print("Validating for string: " + data);
		String[] loginInfo = data.split("-");
		String user = loginInfo[1].trim();
		String password = loginInfo[2].trim();
		String charID = loginInfo[3].trim();

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
				return true;
			} else {
				Log.print("Password Check Failed");
				return false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;

	}

}
