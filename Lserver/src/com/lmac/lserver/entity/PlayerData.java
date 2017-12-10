package com.lmac.lserver.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lmac.lserver.main.SQLLoader;
import com.lmac.lserver.utils.Log;

public class PlayerData {

	int id;
	int level;
	int zone_id;
	Connection conn = null;

	String name;
	float xcoord, ycoord;

	public PlayerData(int id) {
		this.id = id;
		this.conn = SQLLoader.getConnection();
	}

	public void getPlayerData() {

		String query = "SELECT name, level, str_stat, con_stat, agi_stat, int_stat, xcoord, ycoord, zone_id, account_id, hp FROM players WHERE player_id=?";
		if (conn == null) {
			Log.error("SQL connection == null");
		}
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				name = rs.getString("name");
				level = rs.getInt("level");
				xcoord = rs.getFloat("xcoord");
				ycoord = rs.getFloat("ycoord");
				zone_id = rs.getInt("zone_id");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getX() {
		return xcoord;
	}
	public float getY() {
		return ycoord;
	}
	public int getLevel() {
		return level;
	}
	public int getZoneID() {
		return zone_id;
	}
}
