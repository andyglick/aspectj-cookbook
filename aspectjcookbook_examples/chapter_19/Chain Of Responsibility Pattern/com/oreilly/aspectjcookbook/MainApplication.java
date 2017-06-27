package com.oreilly.aspectjcookbook;

public class MainApplication
{
	public static void main(String[] args)
	{
		// Setup our applications pseudo GUI objects
		Manager manager = new Manager();
		PrintButton printButton = new PrintButton();
		PrintDialog printDialog = new PrintDialog();

		HelpChain.aspectOf().setSuccessor(printButton, printDialog);
		HelpChain.aspectOf().setSuccessor(printDialog, manager);

		manager.add(printDialog);
		printDialog.add(printButton);

		// Start the printButtons pseudo user event timer
		printButton.startEvents();

		// Perform a wait
		// and then close the application
		long application_run_duration = 10000l;
		try
		{
			Thread.sleep(application_run_duration);
		}
		catch (Exception e) {}
		
		// Stop the printButtons pseudo user event timer
		printButton.stopEvents();
	}
}
