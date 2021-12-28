package com.oreilly.aspectjcookbook;

public class MainApplication
{
	public static void main(String[] args)
	{
		System.out.println("Attempting to correctly use a socket staying within the constraints of the states");
		TCPConnection connection1 = new TCPConnection();
		connection1.acknowledge();
		connection1.sendData(new String("Data to send").getBytes());
		connection1.close();
		
		System.out.println("\nAttempting to incorrectly use the TCP connection, testing the states");
		TCPConnection connection2 = new TCPConnection();
		connection2.sendData(new String("Data to send").getBytes());
		connection2.acknowledge();
		connection2.close();
		connection2.sendData(new String("Data to send").getBytes());
	}
}
