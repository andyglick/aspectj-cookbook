package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.SingletonPattern;

public aspect PrinterSingleton extends SingletonPattern
{
	declare parents: Printer implements Singleton;
	
	declare parents: SpecializedPrinter implements NonSingleton;
 
}
