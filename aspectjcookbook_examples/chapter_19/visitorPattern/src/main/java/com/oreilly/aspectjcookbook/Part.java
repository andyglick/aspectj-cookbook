package com.oreilly.aspectjcookbook;

public abstract class Part
{
	private String serial;

	public Part(String serial)
	{
		this.serial = serial;
	}

	protected String getSerial()
	{
		return this.serial;
	}
	
	public abstract String getDescription();
}
