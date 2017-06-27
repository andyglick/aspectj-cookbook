package com.oreilly.aspectjcookbook;

public class HardDisk extends Part
{
	public HardDisk(String serial)
	{
		super(serial);
	}

	public String getDescription()
	{
		return "Hard Disk, serial no: " + this.getSerial();
	}
}
