package com.oreilly.aspectjcookbook;

public class PentiumComputerCreator implements ComputerCreator
{
	public Computer createComputer(String serial)
	{
		Processor processor = new Processor("Pentium 4 : 9089085043");
		Motherboard motherboard = new Motherboard("019283", processor);
		HardDisk hardDisk = new HardDisk("738947");
		FloppyDisk floppyDisk = new FloppyDisk("93746");
		return new PentiumFourComputer(serial, motherboard, hardDisk, floppyDisk);
	}
}
