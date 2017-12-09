package com.lmac.lserver.entity;

public class PlayerMP extends Entity {
	
	private int port;
	private String ip;
	private int playerID;
	private String name;
	private float x, y;
	private int zoneID;
	
	public PlayerMP(PlayerData data, int port, String ip) {
		
		this.port = port;
		this.ip = ip;
		
		this.name = data.getName();
		this.playerID = data.getID();
		this.zoneID = data.getZoneID();
		this.x = data.getX();
		this.y = data.getY();
		
		
		
		
	}
	
	
}
