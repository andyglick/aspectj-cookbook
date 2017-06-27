
/**
 * <p>Title: Recipe 5.1.1</p>
 * <p>Description: Simple Class for demonstrating the call(Signature) pointcut</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public class MyClass
{
	public void foo(int number, String name)
	{
		System.out.println("Inside foo (int, String)");
	}

	public static void main(String[] args)
	{
		// Create an instance of MyClass
		MyClass myObject = new MyClass();
		// Make the call to foo
		myObject.foo(1, "Russ Miles");
	}
}