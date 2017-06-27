/**
 * <p>Title: ImplementInterfaceRecipe aspect for Recipe 13.2</p>
 * <p>Description: Simple aspect for demonstrating the ability to apply an interface to a class</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect ImplementInterfaceRecipe
{
	declare parents : MyClass implements MyInterface;
}
