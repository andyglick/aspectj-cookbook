package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.VisitorPattern;

public aspect InventoryVisitor extends VisitorPattern 
{
	declare parents : FloppyDisk implements Element;

	declare parents : HardDisk implements Element;
	
	declare parents : Processor implements Element;

	declare parents : Computer implements CompositeElement;

	declare parents : Motherboard implements CompositeElement;

	declare parents : InventoryReport implements Result;

	public Element[] Computer.getElements()
	{
		Element[] elements = new Element[3];
		elements[0] = this.getMotherboard();
		elements[1] = this.getHardDisk();
		elements[2] = this.getFloppyDisk();
		return elements;
	}

	public Element[] Motherboard.getElements()
	{
		Element[] elements = new Element[1];
		elements[0] = this.getProcessor();
		return elements;
	}

}