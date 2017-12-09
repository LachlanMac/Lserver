package com.lmac.lserver.net;

import java.net.DatagramPacket;

public class Packet {

	private final static int PACKET_SIZE = 512;
	protected byte[] data;
	protected int playerID;
	public Packet(int playerID) {
		this.playerID = playerID;
		data = new byte[512];
		
	}
	
	
	public String getData() {
		return "Basic Packet";
	}
	
	
	
	
	
	
	
	
	
	
	public static DatagramPacket getEmptyPacket(){
		
		byte[] data = new byte[PACKET_SIZE];
		
		return new DatagramPacket(data, data.length);
		
		
	}
	
	
}


