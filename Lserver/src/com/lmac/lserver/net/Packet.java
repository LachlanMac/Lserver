package com.lmac.lserver.net;

import java.net.DatagramPacket;

public class Packet {

	private final static int PACKET_SIZE = 512;
	
	public static DatagramPacket getEmptyPacket(){
		
		byte[] data = new byte[PACKET_SIZE];
		
		return new DatagramPacket(data, data.length);
		
		
	}
	
	
}


