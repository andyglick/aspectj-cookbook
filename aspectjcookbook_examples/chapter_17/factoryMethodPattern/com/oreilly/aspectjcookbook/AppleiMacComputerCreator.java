package com.oreilly.aspectjcookbook;

public class AppleiMacComputerCreator implements ComputerCreator
{
	public Computer createComputer(String serial)
	{
		Processor processor = new Processor("Apple iMac : 9089085043");
		Motherboard motherboard = new Motherboard("33243", processor);
		HardDisk hardDisk = new HardDisk("767567");
		return new AppleiMacComputer(serial, motherboard, hardDisk);
	}
}
