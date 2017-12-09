package com.lmac.lserver.main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.lmac.lserver.utils.Log;



public class LoginListener extends Listener {
	

	byte[] request = new byte[128];
	DatagramPacket loginRequest = new DatagramPacket(request, request.length);
	byte[] response = new byte[128];
	DatagramPacket loginResponse = new DatagramPacket(response, response.length);
	LoginValidator validator;
	
	public LoginListener(DatagramSocket socket) {
		super(socket);
		
		validator = new LoginValidator();
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		
		while(true) {
			
			try {
				Log.print("Listening for Login Request");
				//listen until a request is made
				socket.receive(loginRequest);
				
				int port = loginRequest.getPort();
				InetAddress address = loginRequest.getAddress();
				String ip = address.getHostAddress();
				String received = new String(loginRequest.getData());
				//parse login info
			
				boolean loginConf = validator.validate(received);
				
				if(loginConf == true){
				
					
					byte[] conf = new byte[128];
					conf = new String("confirmed").getBytes();
					DatagramPacket loginConfirmation = new DatagramPacket(conf, conf.length, address, port);
					Log.print("Sending Login Confirmation");
					socket.send(loginConfirmation);
					
					
					
				}else{
					byte[] denial = new byte[128];
					denial = new String("denied").getBytes();
					DatagramPacket loginFailure = new DatagramPacket(denial, denial.length, address, port);
					Log.print("Sending Login Failure");
					socket.send(loginFailure);
					
				}
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
	}

}
