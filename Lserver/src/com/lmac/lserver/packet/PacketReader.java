package com.lmac.lserver.packet;

import com.lmac.lserver.utils.Log;

public class PacketReader {

	
	
	public PacketReader(){
		
		
	}
	
	public void readPacket(String packetID, String packetData){
		
	
	        switch (packetID) {
	            case "05":  parseMovePacket(packetData);
	                     break;
	            case "02":  parseDisconnectPacket(packetData);
	                     break;
	           
	            default: Log.print("Invalid Packet ID");
	                     break;
	        }
	}
	
	public void parseMovePacket(String packetData){
		
		String[] data = packetData.split("-");
		
		int playerID = Integer.parseInt(data[1]);
		float xCoord = Float.parseFloat(data[2]);
		float yCoord = Float.parseFloat(data[3]);
	
	}
	
	public void parseDisconnectPacket(String packetData){
		
		
	}
}
