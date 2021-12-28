package com.oreilly.aspectjcookbook;

public interface ComputerFactory
{
	public Computer createPentiumProcessorComputer();
	
	public Computer createComputerWithHardDisk(HardDisk hardDisk);
	
}
