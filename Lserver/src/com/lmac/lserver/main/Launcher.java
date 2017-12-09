package com.lmac.lserver.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Launcher {
	
	
public static void main(String[] args){
		
		AppGameContainer server;
		try {
			server = new AppGameContainer(new Lserver("SERVER prealpha v0.001.15"));
			server.setDisplayMode(1280, 800, false);
			server.setTargetFrameRate(60);
			server.setMaximumLogicUpdateInterval(60);
			server.setVSync(true);
			server.setUpdateOnlyWhenVisible(false);
			server.setAlwaysRender(true);
			// start game
			server.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
