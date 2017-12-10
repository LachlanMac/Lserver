package com.lmac.lserver.net;

import java.net.DatagramPacket;
import java.net.InetAddress;




	public abstract class Packet {

		protected InetAddress destinationAddress;
		protected int destinationPort;

		public Packet() {

		}

		public abstract DatagramPacket encodePacket(InetAddress destinationAddress, int destinationPort);

		public abstract void decodePacket(DatagramPacket p);
		

		public int getDestinationPort() {

			return destinationPort;

		}
	}



