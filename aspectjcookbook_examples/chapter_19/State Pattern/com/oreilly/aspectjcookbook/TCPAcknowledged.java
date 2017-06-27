package com.oreilly.aspectjcookbook;

public class TCPAcknowledged implements TCPState
{
	private SocketConnection connection;

	public void close()
	{
		System.out.println("Close was attempted on an Acknowledged connection - connection closed");
		this.connection.setConnected(false);
	}

	public void acknowledge()
	{
		System.out.println("Acknowledge was attempted on an Acknowledged connection - ignored");	
	}

	public boolean sendData(byte[] data)
	{
		System.out.println("Send Data was attempted on an Acknowledged connection - data sent:");
		System.out.println(new String(data));
		
		return true;
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
