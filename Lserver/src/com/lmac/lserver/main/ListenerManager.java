package com.lmac.lserver.main;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

import com.lmac.lserver.net.PacketExecutor;
import com.lmac.lserver.utils.Log;
import com.lmac.lserver.utils.Transmission;

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

	LoginListener loginListener;
	ServerListener serverListener;
	ServerSender serverSender;
	Transmission io;
	ConnectionManager cm;

	public ListenerManager(int loginPort, int serverPort, ConnectionManager cm, Transmission io) {

		try {
			this.io = io;
			this.loginSocket = new DatagramSocket(loginPort);
			this.serverSocket = new DatagramSocket(serverPort);
			this.cm = cm;
		} catch (SocketException e) {
			Log.error("Could not create server sockets");
			e.printStackTrace();
		}

	}

	public void startListeners() {

		loginListener = new LoginListener(loginSocket, cm);
		serverListener = new ServerListener(serverSocket, cm, io);
		serverSender = new ServerSender(serverSocket, cm, io);
		
		loginListener.start();
		serverListener.start();
		serverSender.start();
		
	}

	public ServerSender getSender() {
		return serverSender;
	}

	public ServerListener getListener() {
		return serverListener;
	}
}
