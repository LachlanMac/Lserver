package com.lmac.lserver.main;

import java.net.InetAddress;

public class PlayerConnection {

	
	private final static int TIME_OUT = 600;
	private int strikes = 0;
	private int timeOutCounter = 0;
	int playerID;
	InetAddress address;
	int port;
	boolean isConnected;

	int packetCheck = 0;
	
	public PlayerConnection(int playerID, InetAddress address, int port) {
		this.playerID = playerID;
		this.address = address;
		this.port = port;

	}

	public void update(){
		timeOutCounter++;
		if(timeOutCounter > TIME_OUT){
			if (packetCheck == 0){
				strikes++;
			}
		}
		
		
	}
	
	
	
	
	public void connect() {
		isConnected = true;
	}

	public void disconnect() {
		isConnected = false;
	}

	public boolean getConnection() {
		return isConnected;
	}

	
	public int getPlayerID(){
		return playerID;
	}
	public int getPort(){
		return port;
	}
	
	public InetAddress getInetAddress(){
		return address;
	}
	public String getAddress(){
		
		return address.getHostAddress();
		
	}
	public int getStrikes(){
		return strikes;
	}
}
