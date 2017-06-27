/**
 * <p>Title: DefaultInterfaceImplementation aspect for Recipe 13.3</p>
 * <p>Description: Simple aspect for demonstrating the ability to create a default implementation for an interface.</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect DefaultInterfaceImplementationRecipe
{
	declare parents : MyClass implements MyInterface;
	
	// Declare the default implementation of the bar method
	public void MyInterface.bar(String name)
	{
		System.out.println("bar(String) called on " + this);
	}
}
