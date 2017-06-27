/**
 * <p>Title: ExtendClassRecipe aspect for Recipe 13.2</p>
 * <p>Description: Simple aspect for demonstrating the ability to extend classes with new attributes and methods using aspects.</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect ExtendClassRecipe
{
	
	private int MyClass.newVariable = 20;
	
	public int MyClass.bar(String name)
	{
		System.out.println("In bar(String name), name:" + name);
		return this.newVariable;
	}
}
