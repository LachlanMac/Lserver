package com.lmac.lserver.main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.lmac.lserver.packet.PacketReader;
import com.lmac.lserver.utils.Log;
import com.lmac.lserver.utils.Transmission;

public class ServerListener extends Listener {
	

	private byte[] inData;
	private DatagramPacket inPacket;
	PacketReader pr = new PacketReader();
	ConnectionManager cm;
	Transmission io;
	public ServerListener(DatagramSocket socket, ConnectionManager cm, Transmission io) {
		super(socket);
		this.cm = cm;
		this.io = io;
		
	}
	
	
public void run() {
	Log.print("Server Listener Started");
		while(true) {
			
			try {
				
				inData = new byte[512];
				inPacket = new DatagramPacket(inData, inData.length);
				
				socket.receive(inPacket);
				
				io.rx();
				String received = new String(inPacket.getData());
				
				String packetID =  received.substring(0, 2);
				String packetData = received.substring(2);
				pr.readPacket(packetID, packetData);
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
	}

	
	

}
