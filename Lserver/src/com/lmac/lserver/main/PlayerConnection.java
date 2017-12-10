package com.lmac.lserver.main;

import java.net.InetAddress;

import com.lmac.lserver.utils.Log;

public class PlayerConnection {

	private final static int TIME_OUT = 4;
	private int strikes = 0;
	private int timeOutCounter = 0;
	int playerID;
	InetAddress address;
	int port;
	boolean isConnected;
	private ConnectionManager cm;
	int packetCheck = 0;

	public PlayerConnection(int playerID, InetAddress address, int port, ConnectionManager cm) {
		this.playerID = playerID;
		this.address = address;
		this.port = port;
		this.cm = cm;
	}

	public void update() {
		timeOutCounter++;
		if (timeOutCounter > TIME_OUT) {
		
			disconnect();

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

	public int getPlayerID() {
		return playerID;
	}

	public int getPort() {
		return port;
	}

	public InetAddress getInetAddress() {
		return address;
	}

	public String getAddress() {

		return address.getHostAddress();

	}

	public int getStrikes() {
		return strikes;
	}

	public void resetTimeout() {
		timeOutCounter = 0;
	}
}
