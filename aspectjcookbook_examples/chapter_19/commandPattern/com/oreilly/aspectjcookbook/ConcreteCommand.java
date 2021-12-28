package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.CommandPattern;

public aspect ConcreteCommand extends CommandPattern 
{
	declare parents : TimedEvent implements CommandInvoker;
	declare parents : Printer implements CommandReceiver;
	declare parents : VCardPrinter implements CommandReceiver;
	declare parents : BusinessCard implements Command;

	public void BusinessCard.executeCommand(CommandReceiver receiver)
	{
		if (receiver instanceof Printer)
		{
			((Printer) receiver).println(this.toString());
		} else
		{
			((VCardPrinter) receiver).printVCard(this);
		}
	}

	public void executeCommand(CommandReceiver receiver)
	{
		((Printer) receiver).println("Command triggered on printer receiver");
	}

	protected pointcut commandTrigger(CommandInvoker invoker) : call(
		void TimedEvent.timedOut())
		&& target(invoker);
}
