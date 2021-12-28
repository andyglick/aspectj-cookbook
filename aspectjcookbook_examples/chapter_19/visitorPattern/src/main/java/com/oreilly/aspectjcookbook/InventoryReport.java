package com.oreilly.aspectjcookbook;

import java.util.Date;

public class InventoryReport
{
	private Date reportCollatedDate = new Date();
	private StringBuffer report = new StringBuffer();

	public void appendToReport(String newInformation)
	{
		report.append(newInformation + '\n');
	}

	public void printReport()
	{
		System.out.println(
			"Inventory Report Prepared on: " + this.reportCollatedDate);
		System.out.println(report.toString());
	}
}