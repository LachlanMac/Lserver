package com.lmac.lserver.main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.LinkedBlockingQueue;

import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lserver.net.Packet;
import com.lmac.lserver.utils.Log;
import com.lmac.lserver.utils.Transmission;

public class ServerSender extends Thread {

	private LinkedBlockingQueue<Packet> sendQueue;

	private int port;
	private DatagramSocket socket = null;
	private InetAddress address;
	private byte[] inData, outData;
	StateBasedGame game;
	ConnectionManager cm;
	Transmission io;
	
	public ServerSender(DatagramSocket socket, ConnectionManager cm, Transmission io) {
		this.socket = socket;
		this.cm = cm;
		this.io = io;
		sendQueue = new LinkedBlockingQueue<Packet>();
	}

	@Override
	public void run() {
		Log.print("Server Sender Started");
		while (true) {
			if (cm.getPlayerSize() == 0) {

			} else {
			// get all the packets

				if (!sendQueue.isEmpty()) {

					// for all the players in the game
					for (int i = 0; i < cm.getPlayerList().size(); i++) {


						DatagramPacket out = sendQueue.peek().encodePacket(cm.getPlayerList().get(i).getInetAddress(),
								cm.getPlayerList().get(i).getPort());
						try {
							socket.send(out);
							io.tx();
						} catch (IOException e) {
							e.printStackTrace();
						}

					}

					sendQueue.poll();
				}
			}
		}

	}

	public void addPacket() {

	}

	public void addPacket(Packet p) {

		sendQueue.add(p);

	}
}
