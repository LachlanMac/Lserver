package com.lmac.lserver.net;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class LoginPacket extends Packet {

	@Override
	public DatagramPacket encodePacket(InetAddress destinationAddress, int destinationPort) {
		
		return null;
	}

	@Override
	public void decodePacket(DatagramPacket p) {
	
	}

}
