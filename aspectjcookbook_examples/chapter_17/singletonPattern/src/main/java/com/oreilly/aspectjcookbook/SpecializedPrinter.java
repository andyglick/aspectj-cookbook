package com.oreilly.aspectjcookbook;

public class SpecializedPrinter extends Printer
{
	public SpecializedPrinter()
	{
		super();
		System.out.println("Specialized Printer Constructed");
	}
	
	public void print(String output)
	{
		System.out.println("Printing from Specialized Printer: " + this + "\n" +
				output);
	}
}
