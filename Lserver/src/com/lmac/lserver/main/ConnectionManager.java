package com.lmac.lserver.main;

import java.util.ArrayList;
import java.util.Vector;

import com.lmac.lserver.utils.Log;

public class ConnectionManager {

	Vector<PlayerConnection> players;
	
	
	public ConnectionManager(){
		
		players = new Vector<PlayerConnection>();
		
	}
	
	public void update(){
		
		
		
	}
	
	public void addConnection(PlayerConnection player){
		
		Log.print("Added player (ID:"+ player.getPlayerID() +") to the server [address:" + player.getAddress() + ":" + player.getPort());
		player.connect();
		players.add(player);
		
		
	}
	
	public Vector<PlayerConnection> getPlayerList(){
		return players;
	}
	
	public int getPlayerSize(){
		return players.size();
	}
	
}
