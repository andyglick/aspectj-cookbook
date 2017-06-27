package com.oreilly.aspectjcookbook;

public interface TCPState
{
	public void close();
	
	public void acknowledge();
	
	public boolean sendData(byte[] data);
	
	public SocketConnection getConnection();
	
	public void setConnection(SocketConnection connection);
}
