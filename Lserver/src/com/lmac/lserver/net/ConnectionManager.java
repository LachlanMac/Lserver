package com.lmac.lserver.net;

import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import com.lmac.lserver.main.LoginManager;
import com.lmac.lserver.utils.Log;


public class ConnectionManager {
	
	private int port;
	private DatagramSocket socket;
	private ArrayList<Thread> connectionList;
	
	
	public ConnectionManager(int port){
		this.port = port;
	
		try {
			
			this.socket = new DatagramSocket(port);
			
		} catch (SocketException e) {
			Log.error("Socket could not be created on port : " + port);
			e.printStackTrace();
		}
	
	}
	
	
	public void createListeners(int n){
		
		connectionList = new ArrayList<Thread>();
		
		
		for(int i = 0; i < n; i++){
			Log.print("Adding Connection Thread");
			connectionList.add(new Thread(new Listener(socket, this)));
			connectionList.get(i).start();
		}
		
	}
	
	
}
