
public class MyClass
{
	public void foo(int number, String name)
	{
		System.out.println("Inside foo (int, String) with args: " + number + ":" + name);
	}

	public static void main(String[] args)
	{
		// Create an instance of MyClass
		MyInterface myObject = new MyClass();
		// Make the call to foo
		myObject.foo(1, "Russ");
	}
}