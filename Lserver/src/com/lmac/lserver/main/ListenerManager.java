package com.lmac.lserver.main;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

import com.lmac.lserver.net.PacketExecutor;
import com.lmac.lserver.utils.Log;

public class ListenerManager {
	// This class receives packets on a socket and decodes them.

	// ports the servers are running on
	private int loginPort;
	private int serverPort;
	private int chatPort;

	// create the serverSocket
	private DatagramSocket serverSocket;
	// creates the loginSocket
	private DatagramSocket loginSocket;
	// cat server socket
	private DatagramSocket chatSocket;

	public ListenerManager(int loginPort, int serverPort) {

		try {

			this.loginSocket = new DatagramSocket(loginPort);
			this.serverSocket = new DatagramSocket(serverPort);

		} catch (SocketException e) {
			Log.error("Could not create server sockets");
			e.printStackTrace();
		}

	}
	
	public void startListeners() {
		
		new LoginListener(loginSocket).start();
		
		
		
		
	}
	

}
