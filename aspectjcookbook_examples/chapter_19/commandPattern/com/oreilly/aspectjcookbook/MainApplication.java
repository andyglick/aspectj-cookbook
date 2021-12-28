package com.oreilly.aspectjcookbook;

public class MainApplication
{
	public static void main(String[] args)
	{
		TimedEvent event1 = new TimedEvent(1000);
		TimedEvent event2 = new TimedEvent(5000);
		TimedEvent event3 = new TimedEvent(7000);
		TimedEvent event4 = new TimedEvent(10000);

		ConcreteCommand.Command com1 =
			new BusinessCard(
				"Russ",
				"Miles",
				"Author",
				"russmiles@nospam.co.uk");
		ConcreteCommand.Command com2 =
			new BusinessCard(
				"Kim",
				"Hamilton",
				"Software Guru",
				"kim@nospam.com");

		ConcreteCommand.aspectOf().setCommand(event1, com1);
		ConcreteCommand.aspectOf().setReceiver(com1, new Printer());

		ConcreteCommand.aspectOf().setCommand(event2, com2);
		ConcreteCommand.aspectOf().setReceiver(com2, new VCardPrinter());

		ConcreteCommand.aspectOf().setCommand(event3, com1);

		ConcreteCommand.aspectOf().setCommand(event4, com2);

	}
}
