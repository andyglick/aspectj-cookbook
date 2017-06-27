package com.oreilly.aspectjcookbook;

public class TCPConnection
{
	private TCPState state;

	public void close()
	{
		this.state.close();
	}

	public void acknowledge()
	{
		this.state.acknowledge();
	}

	public boolean sendData(byte[] data)
	{
		return this.state.sendData(data);
	}

	public TCPState getState()
	{
		return state;
	}

	public void setState(TCPState state)
	{
		this.state = state;
	}

}
