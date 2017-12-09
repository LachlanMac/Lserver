package com.lmac.lserver.net;

public class MovePacket extends Packet{
	
	
	
	public MovePacket(int playerID) {
		super(playerID);
		
	}

	public String getData() {
		
		return playerID + ": x, y";
		
	}
	
}
