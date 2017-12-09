package com.lmac.lserver.net;

import java.net.DatagramPacket;
import java.net.InetAddress;




	public abstract class Packet {

		protected InetAddress destinationAddress;
		protected int destinationPort;

		public Packet() {

		}

		public abstract DatagramPacket getPacket(InetAddress destinationAddress, int destinationPort);

		

		public int getDestinationPort() {

			return destinationPort;

		}
	}



