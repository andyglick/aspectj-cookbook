package com.oreilly.aspectjcookbook;

public class TCPListen implements TCPState
{
	private SocketConnection connection;

	public void close()
	{
		System.out.println("Close was attempted on a Listening connection - Connection Closed");
		this.connection.setConnected(false);	
	}

	public void acknowledge()
	{
		System.out.println("Acknowledge was attempted on a Listening connection - Connection Acknowledged");	
		this.connection.setConnected(true);
	}

	public boolean sendData(byte[] data)
	{
		System.out.println("Send Data was attempted on a Listening connection - ignored");
		return false;
	}

	public SocketConnection getConnection()
	{
		return connection;
	}

	public void setConnection(SocketConnection connection)
	{
		this.connection = connection;
	}
}
