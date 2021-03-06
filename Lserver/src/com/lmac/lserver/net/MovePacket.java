package com.lmac.lserver.net;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class MovePacket extends Packet {

	private byte[] moveData;
	private final int PACKET_ID = 05;
	
	
	public MovePacket(byte[] moveData) {

		this.moveData = moveData;

	}

	@Override
	public DatagramPacket encodePacket(InetAddress destinationAddress, int destinationPort) {

		DatagramPacket p = new DatagramPacket(moveData, moveData.length, destinationAddress, destinationPort);

		return p;
	}

	@Override
	public void decodePacket(DatagramPacket p) {
		
	}

}
