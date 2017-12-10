package com.lmac.lserver.packet;

import com.lmac.lserver.main.ConnectionManager;
import com.lmac.lserver.main.PlayerConnection;
import com.lmac.lserver.main.ServerSender;
import com.lmac.lserver.net.MPConnectPacket;
import com.lmac.lserver.net.MPPlayerPacket;


public class PacketSender {

	private ServerSender sender;
	private ConnectionManager cm;

	public PacketSender(ServerSender sender, ConnectionManager cm) {
		this.sender = sender;
		this.cm = cm;

	}

	public void sendMPConnectPacket(byte[] data) {

		sender.addPacket(new MPConnectPacket(data));

	}

	public void sendMPConnectionPacket(byte[] data) {
		
		PlayerConnection p;
		
		for (int i = 0; i < cm.getPlayerList().size(); i++) {

			p = cm.getPlayerList().get(i);
			
			
			
			
			
			sender.addPacket(new MPPlayerPacket(data));

			
			
		}
	}

}
