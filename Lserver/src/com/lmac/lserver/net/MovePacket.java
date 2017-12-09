package com.lmac.lserver.net;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class MovePacket extends Packet {

	private byte[] moveData;

	public MovePacket(byte[] moveData) {

		this.moveData = moveData;

	}

	@Override
	public DatagramPacket getPacket(InetAddress destinationAddress, int destinationPort) {

		DatagramPacket p = new DatagramPacket(moveData, moveData.length, destinationAddress, destinationPort);

		return p;
	}

}
