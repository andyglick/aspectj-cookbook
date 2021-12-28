package com.oreilly.aspectjcookbook;

public class Motherboard extends Part
{
	private Processor processor;

	public Motherboard(String serial, Processor processor)
	{
		super(serial);
		this.processor = processor;
	}

	public String getDescription()
	{
		return "Motherboard, serial no: " + this.getSerial();
	}

	public Processor getProcessor()
	{
		return this.processor;
	}

	public String toString()
	{
		return this.getDescription() + '\n' + this.processor.getDescription();
	}
}
