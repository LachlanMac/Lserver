package com.lmac.lserver.main;

import java.net.DatagramSocket;

import com.lmac.lserver.utils.Log;

public class Listener extends Thread{
	
	DatagramSocket socket;
	
	public Listener(DatagramSocket socket) {
		
		this.socket = socket;
		
	}

	
	public void run() {
		
	}

	
	
}
