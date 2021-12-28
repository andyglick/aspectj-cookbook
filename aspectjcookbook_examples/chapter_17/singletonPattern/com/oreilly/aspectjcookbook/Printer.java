package com.oreilly.aspectjcookbook;

public class Printer
{
	public Printer()
	{
		System.out.println("Printer constructed");
	}
	
	public void print(String output)
	{
		System.out.println("Printing from Printer: " + this + "\n" + output);
	}
}
