package com.lmac.lserver.net;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Vector;

import com.lmac.lserver.main.PlayerConnection;

public class MPPlayerPacket extends Packet {

	private byte[] serverData;

	public MPPlayerPacket(byte[] serverData) {
		this.serverData = serverData;

	}

	@Override
	public DatagramPacket encodePacket(InetAddress destinationAddress, int destinationPort) {

		DatagramPacket p = new DatagramPacket(serverData, serverData.length, destinationAddress, destinationPort);
		return p;
	}

	@Override
	public void decodePacket(DatagramPacket p) {
		// TODO Auto-generated method stub

	}

}
