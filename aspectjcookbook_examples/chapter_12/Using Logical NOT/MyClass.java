
public class MyClass
{
	public void foo(int number, String name)
	{
	   System.out.println("Inside constructional method MyClass.void foo(int, String)");
	}
	
	public void bar()
	{
	   System.out.println("Inside constructional method MyClass.void bar ()");
	}
	
	public static final void main (String args[])
	{
	   // Create instances of the objects
		MyClass myObject = new MyClass();
		
		// Exercise all of the calls on the MyClass object
		myObject.foo(1,"Russ Miles");
		myObject.bar();
	}
}
