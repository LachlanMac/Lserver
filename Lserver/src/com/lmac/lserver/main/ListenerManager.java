package com.lmac.lserver.main;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import com.lmac.lserver.packet.PacketReader;
import com.lmac.lserver.utils.Log;
import com.lmac.lserver.utils.Transmission;

public class ListenerManager {
	// This class receives packets on a socket and decodes them.

	// create the serverSocket
	private DatagramSocket serverSocket;
	// creates the loginSocket
	private DatagramSocket loginSocket;
	// cat server socket
	private DatagramSocket chatSocket;
	
	PacketReader pr;
	
	ServerListener serverListener;
	ServerSender serverSender;
	Transmission io;
	ConnectionManager cm;

	public ListenerManager(int serverPort, ConnectionManager cm, Transmission io, PacketReader pr) {

		try {
			this.pr = pr;
			this.io = io;
		
			this.serverSocket = new DatagramSocket(serverPort);
			this.cm = cm;
			
			serverListener = new ServerListener(serverSocket, cm, io, pr);
			serverSender = new ServerSender(serverSocket, cm, io);
			pr.setSender(serverSender);
			
			
		} catch (SocketException e) {
			Log.error("Could not create server sockets");
			e.printStackTrace();
		}

	}

	public void startListeners() {

		
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
