package com.oreilly.aspectjcookbook;

public class TCPClosed implements TCPState
{
	private SocketConnection connection;

	public void close()
	{
		System.out.println("Close was attempted on a Closed connection - ignored");	
	}

	public void acknowledge()
	{
		System.out.println("Acknowledge was attempted on a Closed connection - ignored");	
	}

	public boolean sendData(byte[] data)
	{
		System.out.println("Send Data was attempted on a Closed connection - ignored");	
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
