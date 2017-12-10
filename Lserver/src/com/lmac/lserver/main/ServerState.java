package com.lmac.lserver.main;

import java.sql.Connection;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lserver.entity.EntityManager;
import com.lmac.lserver.entity.PlayerMP;
import com.lmac.lserver.net.MovePacket;
import com.lmac.lserver.packet.PacketReader;
import com.lmac.lserver.packet.PacketSender;
import com.lmac.lserver.utils.Log;
import com.lmac.lserver.utils.Transmission;





public class ServerState extends BasicGameState {

	Transmission transmission = new Transmission();
	Connection conn;
	ConnectionManager cm;
	ListenerManager lm;
	
	EntityManager em;
	PacketReader pr;
	PacketSender ps;
	PlayerMP p;
	
	
	@Override
	public void init(GameContainer sContainer, StateBasedGame server) throws SlickException {
		
		
		Log.print("Starting Server");
		
		Log.print("Loading SQL Configuration");
		
		SQLLoader.loadSQLCongfig();
		SQLLoader.createConnection();
		
		
		
		Log.print("Starting Entity Manager");
		em = new EntityManager();
		
		
		
		
		
		
		
		Log.print("Starting Connection Manager");
		cm = new ConnectionManager(em);
	
		
		pr = new PacketReader(cm, em);
			
		
		lm = new ListenerManager(3356, cm, transmission, pr);
		
		ps = new PacketSender(lm.getSender(), cm);
		cm.setPacketSender(ps);
		
		lm.startListeners();

		
		
		
	}

	@Override
	public void render(GameContainer sContainer, StateBasedGame server, Graphics g) throws SlickException {
		transmission.render(g);
		em.render(g);
	}

	@Override
	public void update(GameContainer sContainer, StateBasedGame server, int delta) throws SlickException {

		cm.update();
		em.update();
	}

	@Override
	public int getID() {

		return 0;
		
	}

}
