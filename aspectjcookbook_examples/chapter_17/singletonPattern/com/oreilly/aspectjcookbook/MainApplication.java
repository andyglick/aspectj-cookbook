package com.oreilly.aspectjcookbook;

public class MainApplication
{
	public static void main(String[] args)
	{
		// Create the pseudo gui components
		Window mainWindow = new Window();
		AboutBox aboutBox = new AboutBox();
		AboutBox aboutBox2 = new AboutBox();
		
		mainWindow.printWindowContents();
		aboutBox.printLicenseAgreement();
		aboutBox.printLicenseAgreement();
		mainWindow.printWindowContents();
		aboutBox2.printLicenseAgreement();
		aboutBox2.printLicenseAgreement();
		mainWindow.printWindowContents();
	}
}
