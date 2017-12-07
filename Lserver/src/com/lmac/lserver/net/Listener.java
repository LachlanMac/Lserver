package com.lmac.lserver.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.sql.Connection;

import com.lmac.lserver.main.LoginManager;
import com.lmac.lserver.main.SQLLoader;
import com.lmac.lserver.utils.Log;

public class Listener implements Runnable {

	ConnectionManager cm;
	DatagramSocket socket;
	private boolean isConnected;
	private int port;
	private InetAddress address;
	LoginManager lm = new LoginManager();
	
	

	public Listener(DatagramSocket socket, ConnectionManager cm) {
		this.cm = cm;
		this.socket = socket;
		isConnected = false;
	}

	@Override
	public void run() {

		listen();
		
		while (isConnected) {

			Log.print("Connection Tick");
			checkConnection();
		}

	}

	
	public void listen(){
		
		byte[] loginPacket = new byte[128];
		DatagramPacket loginRequest = new DatagramPacket(loginPacket, loginPacket.length);
		
		
		try {
			
			socket.receive(loginRequest);
			port = loginRequest.getPort();
			address = loginRequest.getAddress();
			String received = new String(loginRequest.getData());
			String[] loginInfo = received.split("-");
			String user = loginInfo[1].trim();
			String password = loginInfo[2].trim();
			
			boolean loginConf = lm.login(user, password);
			if(loginConf == true){
				
				isConnected = true;
				
				byte[] conf = new byte[128];
				conf = new String("confirmed").getBytes();
				DatagramPacket loginConfirmation = new DatagramPacket(conf, conf.length, address, port);
				socket.send(loginConfirmation);
				
				
				
				loop();
				
			}else{
				isConnected = false;
			}
			
			
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void loop(){
		
		while(isConnected){
		
		Log.print("IN CONNECTION LOOP");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		}
	}
	
	
	
	
	
	public void checkConnection() {

		byte[] outData = new byte[128];
		byte[] inData = new byte[128];
		outData = new String("tick").getBytes();

		DatagramPacket heartbeatOut = new DatagramPacket(outData, outData.length, address, port);
		DatagramPacket heartbeatIn = new DatagramPacket(inData, inData.length);
		try {
			
			socket.send(heartbeatOut);
			Log.print("Heart beat sent from server");
			socket.setSoTimeout(2000);

			while (true) {
				try{
				socket.receive(heartbeatIn);
				Log.print("Still Connected");
				
				
				}catch(SocketTimeoutException e){
					isConnected = false;
					Log.print("Client DC'd");
					e.printStackTrace();
				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
