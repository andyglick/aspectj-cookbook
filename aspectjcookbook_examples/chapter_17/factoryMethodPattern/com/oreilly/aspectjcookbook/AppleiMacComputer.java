package com.oreilly.aspectjcookbook;

public class AppleiMacComputer extends Computer
{
	public AppleiMacComputer(String serial, Motherboard motherboard, HardDisk hardDisk)
	{
		super(serial, motherboard, hardDisk, new FloppyDisk("Not Applicable"));

	}
}
