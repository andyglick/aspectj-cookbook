
public class MyClass
{
	public void foo(int number, String name)
	{
		System.out.println("Inside constructional method MyClass.void foo(int, String)");
	}

	public static final void main(String args[])
	{
		// Create instance of the object
		MyClass myObject = new MyClass();

		myObject.foo(1, "Russ Miles");
	}
}
