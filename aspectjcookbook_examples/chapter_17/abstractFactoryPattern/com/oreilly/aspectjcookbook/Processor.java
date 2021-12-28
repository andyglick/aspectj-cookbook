package com.oreilly.aspectjcookbook;

public class Processor extends Part
{
	private String serial;

	public Processor(String serial)
	{
		super(serial);
	}

	public String getDescription()
	{
		return "Processor, serial no: " + this.getSerial();
	}
}
