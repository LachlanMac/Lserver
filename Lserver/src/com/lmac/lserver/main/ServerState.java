package com.lmac.lserver.main;

import java.sql.Connection;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import com.lmac.lserver.utils.Log;





public class ServerState extends BasicGameState {

	
	Connection conn;

	ListenerManager lm;
	@Override
	public void init(GameContainer sContainer, StateBasedGame server) throws SlickException {
		
		
		Log.print("Starting Server");
		
		Log.print("Loading SQL Configuration");
		
		SQLLoader.loadSQLCongfig();
		SQLLoader.createConnection();
	
		
		Log.print("Starting Connection Manager");
		
		//cm = new ConnectionManager(3355);
		//cm.createListeners(3);
		lm = new ListenerManager(3355,3356);
		
		lm.startListeners();
	}

	@Override
	public void render(GameContainer sContainer, StateBasedGame server, Graphics g) throws SlickException {
		
		
	}

	@Override
	public void update(GameContainer sContainer, StateBasedGame server, int delta) throws SlickException {

		
	}

	@Override
	public int getID() {

		return 0;
		
	}

}
