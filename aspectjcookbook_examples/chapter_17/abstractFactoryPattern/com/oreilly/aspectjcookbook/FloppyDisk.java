package com.oreilly.aspectjcookbook;

public class FloppyDisk extends Part
{
	public FloppyDisk(String serial)
	{
		super(serial);
	}
	
	public String getDescription()
	{
		return "Floppy Disk, serial no: " + this.getSerial();
	}
}
