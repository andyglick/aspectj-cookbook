package com.oreilly.aspectjcookbook;

public aspect DefaultComputerFactoryImplementation 
{
	public Computer ComputerFactory.createPentiumProcessorComputer()
	{
		Processor processor = new Processor("Pentium 4 : 9089085043");
		Motherboard motherboard = new Motherboard("019283", processor);
		HardDisk hardDisk = new HardDisk("738947");
		FloppyDisk floppyDisk = new FloppyDisk("93746");
		Computer computer = new Computer("12345", motherboard, hardDisk, floppyDisk);
		return computer;
	}

	public Computer ComputerFactory.createComputerWithHardDisk(HardDisk hardDisk)
	{
		Processor processor = new Processor("Pentium Standard : 123478");
		Motherboard motherboard = new Motherboard("434244", processor);
		FloppyDisk floppyDisk = new FloppyDisk("432434");
		Computer computer = new Computer("56789", motherboard, hardDisk, floppyDisk);
		return computer;
	}
}
