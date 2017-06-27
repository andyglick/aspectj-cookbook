package com.oreilly.aspectjcookbook;

public class Computer extends Part
{
	private Motherboard motherboard;
	private HardDisk hardDisk;
	private FloppyDisk floppyDisk;

	public Computer(
		String serial,
		Motherboard motherboard,
		HardDisk hardDisk,
		FloppyDisk floppyDisk)
	{
		super(serial);
		this.motherboard = motherboard;
		this.hardDisk = hardDisk;
		this.floppyDisk = floppyDisk;
	}

	public String getDescription()
	{
		return "Computer, serial no: " + this.getSerial();
	}
	
	public FloppyDisk getFloppyDisk()
	{
		return floppyDisk;
	}

	public HardDisk getHardDisk()
	{
		return hardDisk;
	}

	public Motherboard getMotherboard()
	{
		return motherboard;
	}

}
