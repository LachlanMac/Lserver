package com.lmac.lserver.entity;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class PlayerMP extends Entity {
	
	private int port;
	private String ip;
	private int playerID;
	private String name;
	private float x, y;
	private int zoneID;
	private Vector2f loc;
	public PlayerMP(PlayerData data, int port, String ip) {
		
		data.getPlayerData();
		
		this.port = port;
		this.ip = ip;
		
		this.name = data.getName();
		this.playerID = data.getID();
		this.zoneID = data.getZoneID();
		this.x = data.getX();
		this.y = data.getY();
		
		
		loc = new Vector2f(x, y);
		
		
		
	}
	
	public void update(){
		
		
	}
	public void render(Graphics g){
		g.setColor(Color.cyan);
		g.draw(new Rectangle(loc.getX(),loc.getY(), 50, 50));
		
	}
	
	public void setLoc(float x, float y){
		loc.set(x, y);
	}
	public int getID(){
		return playerID;
	}
}
