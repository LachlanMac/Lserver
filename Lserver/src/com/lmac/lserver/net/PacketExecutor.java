package com.lmac.lserver.net;

import com.lmac.lserver.utils.Log;

public class PacketExecutor {

	
	public void PacketExecutor() {
		
		
	}
	
	public void executePacket(Packet p) {
		
		Log.print("EXECUTING PACKET");
		Log.print(p.getData());
	}
	
}
