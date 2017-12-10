package com.lmac.lserver.net;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class MPConnectPacket extends Packet{
	
	private byte[] playerData;

	public MPConnectPacket(byte[] playerData) {

		this.playerData = playerData;

	}
	
	
	@Override
	public DatagramPacket encodePacket(InetAddress destinationAddress, int destinationPort) {
		
		DatagramPacket p = new DatagramPacket(playerData, playerData.length, destinationAddress, destinationPort);
		return p;
	}


	@Override
	public void decodePacket(DatagramPacket p) {
		
	}

}
