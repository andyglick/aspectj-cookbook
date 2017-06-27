
public class MyClass
{
	private AnotherClass anotherObject = new AnotherClass();
	
	public void foo(int number, String name)
	{
		// Execise all of the calls on the AnotherClass object
		anotherObject.bar(2);
		
		System.out.println(
		"Inside MyClass.void foo(int, String)");
	}

	public static void main(String[] args)
	{
		// Create an instance of MyClass
		MyClass myObject = new MyClass();
		
		// Make the call to foo
		myObject.foo(1, "Kim");
	}
}