package com.oreilly.aspectjcookbook;

public class Version
{
	private String versionInformation;
	
	public Version()
	{
		// Potentially initialise the version information
		// from a file or configuration management system.
		// For this example we will simply set it.
		System.out.println("Version Constructed");
		this.versionInformation = "Build 0.1";
	}
	
	public String getVersionInformation()
	{
		return this.versionInformation;
	}

}
