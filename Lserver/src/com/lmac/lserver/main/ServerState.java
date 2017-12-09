package com.lmac.lserver.main;

import java.sql.Connection;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lserver.net.MovePacket;
import com.lmac.lserver.utils.Log;
import com.lmac.lserver.utils.Transmission;





public class ServerState extends BasicGameState {

	Transmission transmission = new Transmission();
	Connection conn;
	ConnectionManager cm;
	ListenerManager lm;
	@Override
	public void init(GameContainer sContainer, StateBasedGame server) throws SlickException {
		
		
		Log.print("Starting Server");
		
		Log.print("Loading SQL Configuration");
		
		SQLLoader.loadSQLCongfig();
		SQLLoader.createConnection();
	
		
		Log.print("Starting Connection Manager");
		
		cm = new ConnectionManager();
	
		
		lm = new ListenerManager(3355,3356, cm, transmission);
		
		lm.startListeners();
		
		
		byte[] movePacket = "this is a move packet!".getBytes();
		
		lm.getSender().addPacket(new MovePacket(movePacket));
		
	}

	@Override
	public void render(GameContainer sContainer, StateBasedGame server, Graphics g) throws SlickException {
		transmission.render(g);
		
	}

	@Override
	public void update(GameContainer sContainer, StateBasedGame server, int delta) throws SlickException {

		
	}

	@Override
	public int getID() {

		return 0;
		
	}

}
