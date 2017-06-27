package com.oreilly.aspectjcookbook;

public class MainApplication
{
	public static void main(String[] args)
	{	
		System.out.println("Creating the complex composite architecture that will be visited\n");
		Processor processor = new Processor("564738");
		Motherboard motherboard = new Motherboard("019283", processor);
		HardDisk hardDisk = new HardDisk("738947");
		FloppyDisk floppyDisk = new FloppyDisk("93746");
		Computer computer = new Computer("12345", motherboard, hardDisk, floppyDisk);
		
		System.out.println("Visiting to create report on inventory");
		InventoryReportVisitor inventoryReportVisitor = new InventoryReportVisitor();
		computer.accept(inventoryReportVisitor);
		System.out.println("Visit completed\n");
		
		((InventoryReport) inventoryReportVisitor.getResult()).printReport();
	}
}
