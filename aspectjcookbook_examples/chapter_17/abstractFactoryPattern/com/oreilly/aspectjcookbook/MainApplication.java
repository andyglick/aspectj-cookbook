package com.oreilly.aspectjcookbook;

public class MainApplication
{
	public static void main(String[] args)
	{
		ComputerFactory computerFactory = new DefaultComputerFactory();
		Computer pentiumComputer = computerFactory.createPentiumProcessorComputer();
		
		HardDisk hardDisk = new HardDisk("80 Gb - 1904539");
		Computer specificHardDiskComputer = computerFactory.createComputerWithHardDisk(hardDisk);
		
		System.out.println("2 computers created.");
		System.out.print('\n');
		System.out.println("Computer 1 : ");
		System.out.println(pentiumComputer.toString());
		System.out.print('\n');
		System.out.println("Computer 2 : ");
		System.out.println(specificHardDiskComputer.toString());
	}
}
