package com.lmac.lserver.entity;

import java.util.Vector;

import com.lmac.lserver.main.ConnectionManager;
import com.lmac.lserver.main.PlayerConnection;
import com.lmac.lserver.packet.PacketSender;

public class ServerInfoManager {

	ConnectionManager cm;
	PacketSender ps;
	Vector<PlayerConnection> players;
	byte[] playerInfo;
	
	
	public ServerInfoManager(ConnectionManager cm, PacketSender ps){
		this.cm = cm;
		this.ps = ps;
		this.players = cm.getPlayerList();
		
	}
	
	
	public void update(){
		
		sendPlayerInfo();
		
	}
	
	public void sendPlayerInfo(){
		
		
		
		
		for(int i = 0; i < players.size(); i++){
			
			playerInfo = new byte[512];
			
			
			
			
			
			ps.sendMPConnectionPacket(playerInfo);
			
		}
		
		
		
		
		
		
		
		
		
		
	}
}
