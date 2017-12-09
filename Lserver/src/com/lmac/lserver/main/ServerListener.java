package com.lmac.lserver.main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.lmac.lserver.utils.Log;

public class ServerListener extends Listener {
	

	private byte[] inData;
	private DatagramPacket inPacket;
	
	public ServerListener(DatagramSocket socket) {
		super(socket);
		
		
	}
	
	
public void run() {
		
		while(true) {
			
			try {
				
				inData = new byte[512];
				inPacket = new DatagramPacket(inData, inData.length);
				//listen until a request is made
				socket.receive(inPacket);
				
				String received = new String(inPacket.getData());
				
				String packetID =  received.substring(0, 2);
				
				Log.print("RECEIVED PACK WITH ID: " + packetID);
				
		
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
	}

	
	

}
