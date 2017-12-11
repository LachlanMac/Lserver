package com.lmac.lserver.net;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Vector;

import com.lmac.lserver.main.PlayerConnection;

public class MPPlayerPacket extends Packet {

	private final String PACKET_ID = "70";
	private String playerData;
	private byte[] data;
	public MPPlayerPacket(String playerData) {
		this.playerData = playerData;

	}

	@Override
	public DatagramPacket encodePacket(InetAddress destinationAddress, int destinationPort) {

		String dataS = PACKET_ID + "x=" + playerData + "=" + "data";
		
		data = new byte[128];
		
		data = dataS.getBytes();
		
		
		
		DatagramPacket p = new DatagramPacket(data, data.length, destinationAddress, destinationPort);
		return p;
	}

	@Override
	public void decodePacket(DatagramPacket p) {
		// TODO Auto-generated method stub

	}

}
