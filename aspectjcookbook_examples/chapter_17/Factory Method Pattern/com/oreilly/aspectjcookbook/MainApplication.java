package com.oreilly.aspectjcookbook;

public class MainApplication
{
	public static void main(String[] args)
	{
		System.out.println("Creating Pentium Computer using factory method:");
		ComputerCreator pentiumComputerCreator = new PentiumComputerCreator();
		pentiumComputerCreator.createComputerAndPrintInventory("12345");
		
		System.out.println("\nCreating Apple iMac Computer using factory method:");
		ComputerCreator appleiMacComputerCreator = new AppleiMacComputerCreator();
		appleiMacComputerCreator.createComputerAndPrintInventory("67890");
	}
}
