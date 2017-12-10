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
	PacketReader pr;
	ConnectionManager cm;
	Transmission io;
	LoginValidator validator;
	public ServerListener(DatagramSocket socket, ConnectionManager cm, Transmission io, PacketReader pr) {
		super(socket);
		this.cm = cm;
		this.io = io;
		this.pr = pr;
		this.validator = new LoginValidator();
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
				
				if(packetID.equals("01")){
					
					parseLoginRequestPacket(packetData, inPacket);
					
				}else{
				
				pr.readPacket(packetID, packetData);
				
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
	}

public void parseLoginRequestPacket(String packetData, DatagramPacket inPacket){
	
	String[] data = packetData.split("=");
	
	int port = inPacket.getPort();
	InetAddress address = inPacket.getAddress();
	String ip = address.getHostAddress();
	String received = new String(inPacket.getData());
	//parse login info

	int loginConf = validator.validate(received);
	
	if(loginConf != 0){
	
		
		byte[] conf = new byte[128];
		conf = new String("confirmed").getBytes();
		DatagramPacket loginConfirmation = new DatagramPacket(conf, conf.length, address, port);
		Log.print("Sending Login Confirmation");
		
		try {
			socket.send(loginConfirmation);
			cm.addConnection(new PlayerConnection(loginConf, address, port, cm));
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}else{
		byte[] denial = new byte[128];
		denial = new String("denied").getBytes();
		DatagramPacket loginFailure = new DatagramPacket(denial, denial.length, address, port);
		Log.print("Sending Login Failure");
		try {
			socket.send(loginFailure);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
}
	

}
