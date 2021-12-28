package com.oreilly.aspectjcookbook;

public class Window
{
	public void printWindowContents()
	{
		Printer printer = new SpecializedPrinter();
		printer.print("Contents of a Window");
	}
}
