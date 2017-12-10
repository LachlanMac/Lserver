package com.lmac.lserver.main;

import java.util.ArrayList;
import java.util.Vector;

import com.lmac.lserver.entity.EntityManager;
import com.lmac.lserver.entity.PlayerData;
import com.lmac.lserver.entity.PlayerMP;
import com.lmac.lserver.packet.PacketSender;
import com.lmac.lserver.utils.Log;

public class ConnectionManager {

	Vector<PlayerConnection> players;
	
	EntityManager em;
	PacketSender ps;
	
	int counter = 0;

	public ConnectionManager(EntityManager em) {
		this.em = em;
		players = new Vector<PlayerConnection>();

	}

	public void update() {
		counter++;
		// check every second
		if (counter > 60) {
		
			for (int i = 0; i < players.size(); i++) {
				players.get(i).update();
				if(players.get(i).getConnection() == false){
					removeConnection(players.get(i));
					Log.print("Player has been DC'd");
				}
				
			}

			counter = 0;
		}

	}

	public void addConnection(PlayerConnection player) {

		Log.print("Added player (ID:" + player.getPlayerID() + ") to the server [address:" + player.getAddress() + ":"
				+ player.getPort() + "]");
		
		
		//connects the player
		player.connect();
		//adds the player to connections list
		players.add(player);
		//adds the player to the gameserver
		em.addPlayer(player);
		
		
		
		byte[] mpPlayerData = new String("40=" + player.getPlayerID() + "=" + player.getAddress()).getBytes();
		
		
		ps.sendMPConnectPacket(mpPlayerData);
		
		
		
	}
	
	public void removeConnection(PlayerConnection player){
		
		Log.print("Removing Player [ID:" + player.getPlayerID() + "]  from the server");
		
		player.disconnect();
		
		players.remove(player);
		
		em.removePlayer(player.getPlayerID());
		
	}

	public Vector<PlayerConnection> getPlayerList() {
		return players;
	}

	public int getPlayerSize() {
		return players.size();
	}
	
	public void setPacketSender(PacketSender ps){
		this.ps = ps;
	}
	
	

}
