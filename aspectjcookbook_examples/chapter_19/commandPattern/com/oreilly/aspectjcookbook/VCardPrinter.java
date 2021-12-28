package com.oreilly.aspectjcookbook;

public class VCardPrinter
{
	public void printVCard(BusinessCard bc)
	{
		System.out.println(
			"BEGIN:VCARD\n"
				+ "VERSION:3.0\n"
				+ "N:"
				+ bc.getSurname()
				+ ";"
				+ bc.getFirstName()
				+ ";;;"
				+ "FN:"
				+ bc.getFirstName()
				+ " "
				+ bc.getSurname()
				+ "\n"
				+ "TITLE:"
				+ bc.getJobDescription()
				+ "\n"
				+ "EMAIL;type=WORK;type=pref:"
				+ bc.getEmailAddress()
				+ "\n"
				+ "END:VCARD\n");
	}
}
