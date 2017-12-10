package com.lmac.lserver.entity;

import java.util.ArrayList;
import java.util.Vector;

import org.newdawn.slick.Graphics;

import com.lmac.lserver.main.PlayerConnection;
import com.lmac.lserver.utils.Log;

public class EntityManager {

	public Vector<PlayerMP> players;

	public EntityManager() {

		players = new Vector<PlayerMP>();

	}

	public void update() {
		for (int j = 0; j < players.size(); j++) {

			players.get(j).update();

		}
	}

	public void render(Graphics g) {

		for (int k = 0; k < players.size(); k++) {

			players.get(k).render(g);

		}

	}

	public PlayerMP getPlayerByID(int id) {
		PlayerMP p = null;

		for (int i = 0; i < players.size(); i++) {

			if (players.get(i).getID() == id) {
				p = players.get(i);
			}
			
		}
		
		return p;

	}

	public void addPlayer(PlayerConnection p) {
		Log.print("Adding Player to the List");
		players.add(new PlayerMP(new PlayerData(p.getPlayerID()), p.getPort(), p.getAddress()));

	}

	public void removePlayer(int id) {

		PlayerMP p = getPlayerByID(id);
		players.remove(p);
		

	}

}
