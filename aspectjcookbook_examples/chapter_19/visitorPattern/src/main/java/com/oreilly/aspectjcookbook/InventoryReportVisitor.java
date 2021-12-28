package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.VisitorPattern.Visitor;
import com.oreilly.aspectjcookbook.oopatterns.VisitorPattern.Element;
import com.oreilly.aspectjcookbook.oopatterns.VisitorPattern.CompositeElement;
import com.oreilly.aspectjcookbook.oopatterns.VisitorPattern.Result;

public class InventoryReportVisitor implements Visitor
{
	InventoryReport report = new InventoryReport();

	public void visitElement(Element element)
	{
		this.appendToReport(element);
	}

	public void visitComposite(CompositeElement compositeElement)
	{
		this.appendToReport(compositeElement);

		Element[] elements = compositeElement.getElements();
		for (int elementCount = 0; elementCount < elements.length; elementCount++)
		{
			elements[elementCount].accept(this);
		}
	}

	private void appendToReport(Element element)
	{
		if (element instanceof Part)
		{
			Part part = (Part) element;
			report.appendToReport(part.getDescription());
		}
	}

	public Result getResult()
	{
		return this.report;
	}
}
