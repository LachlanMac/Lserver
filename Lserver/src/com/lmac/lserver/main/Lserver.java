package com.lmac.lserver.main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;



public class Lserver extends StateBasedGame {

	public Lserver(String name) {
		super(name);
		
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		this.addState(new ServerState());
		
	}

}
