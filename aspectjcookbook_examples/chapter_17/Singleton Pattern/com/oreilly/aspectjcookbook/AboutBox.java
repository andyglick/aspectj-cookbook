package com.oreilly.aspectjcookbook;

public class AboutBox
{
	public void printLicenseAgreement()
	{
		Printer printer = new Printer();
		Version version = new Version();
		printer.print(
			"Unreasonable License Agreement for software version: "
				+ version.getVersionInformation());
	}
}
