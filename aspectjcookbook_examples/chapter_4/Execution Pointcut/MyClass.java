
public class MyClass
{
	public void foo(int number, String name)
	{
		System.out.println("************ Business/Application Logic *************");
		System.out.println("Inside constructional method MyClass.void foo(int, String)");
		System.out.println("*****************************************************");
	}

	public static final void main(String args[])
	{
		// Create instance of the object
		MyClass myObject = new MyClass();

		// Exercise all of the calls on the MyClass object
		System.out.println("About to enter the method MyClass.foo(int,String)");
		myObject.foo(1, "Russ Miles");
	}
}
