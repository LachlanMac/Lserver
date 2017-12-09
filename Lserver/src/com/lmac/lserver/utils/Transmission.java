package com.lmac.lserver.utils;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

import com.lmac.lserver.main.ServerListener;
import com.lmac.lserver.main.ServerSender;

public class Transmission {
	
	boolean rx, tx;
	

	
	public Transmission(){
		
		rx = false;
		tx = false;
		
	}
	
	public void update(){
	

	}
	
	public void render(Graphics g){
		g.setColor(Color.red);
		if(rx){
			g.setColor(Color.green);
			rx = false;
		}
		g.draw(new Circle(100, 30, 10));
		g.setColor(Color.red);
		if(tx){
			g.setColor(Color.green);
			tx = false;
		}
		g.draw(new Circle(30, 30, 10));
	}
	
	public void rx(){
		
		rx = true;
	}
	
	public void tx(){
		
		tx = true;
		
	}
	

}
