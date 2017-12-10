package com.lmac.lserver.packet;

import java.util.Vector;

import com.lmac.lserver.entity.EntityManager;
import com.lmac.lserver.entity.PlayerMP;
import com.lmac.lserver.main.ConnectionManager;
import com.lmac.lserver.main.PlayerConnection;
import com.lmac.lserver.main.ServerSender;
import com.lmac.lserver.net.MovePacket;
import com.lmac.lserver.utils.Log;

public class PacketReader {

	EntityManager em;
	ConnectionManager cm;
	ServerSender send;
	PacketSender packetSender;

	public PacketReader(ConnectionManager cm, EntityManager em) {
		this.cm = cm;
		this.em = em;
		

	}

	public void readPacket(String packetID, String packetData) {
		
		switch (packetID) {
		case "05":
			parseMovePacket(packetData);
			break;
		case "02":
			parseDisconnectPacket(packetData);
			break;
		case "88":
			parseHeartBeatPacket(packetData);
			break;
		
		default:
			Log.print("Invalid Packet ID");
			break;
		}
	}
	
	

	
	
	
	public void parseMovePacket(String packetData) {
		
		String[] data = packetData.split("=");

		int playerID = Integer.parseInt(data[1]);
		
		
		float xCoord = Float.parseFloat(data[2]);
		float yCoord = Float.parseFloat(data[3]);

		PlayerMP p = em.getPlayerByID(playerID);

		p.setLoc(xCoord, yCoord);

		String moveP = "05=" + playerID + "=" + xCoord + "=" + yCoord;

		send.addPacket(new MovePacket(moveP.getBytes()));

	}

	public void parseDisconnectPacket(String packetData) {

	}

	public void parseHeartBeatPacket(String packetData) {

		String[] data = packetData.split("=");

		int playerID = Integer.parseInt(data[1]);

		for (int i = 0; i < cm.getPlayerList().size(); i++) {

			if (cm.getPlayerList().get(i).getPlayerID() == playerID) {
				cm.getPlayerList().get(i).resetTimeout();
			}

		}

	}
	public void setSender(ServerSender sender){
		this.send = sender;
	}
}
