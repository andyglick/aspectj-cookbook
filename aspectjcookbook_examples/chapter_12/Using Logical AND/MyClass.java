
public class MyClass
{
	public void foo(int number, String name)
	{
	   System.out.println("Inside constructional method MyClass.void foo(int, String)");
	}
	
	public void foo(float number)
	{
	   System.out.println("Inside constructional method MyClass.void foo(float)");
	}
	
	public void bar()
	{
	   System.out.println("Inside constructional method MyClass.void bar ()");
	}
	
	public void foo(long longNumber, String name)
	{
	   System.out.println("Inside constructional method MyClass.void foo (long, name)");
	}
	
	public static final void main (String args[])
	{
	   // Create instances of the objects
		MyClass myObject = new MyClass();
		
		// Exercise all of the calls on the MyClass object
		myObject.foo(1,"Russ Miles");
		myObject.foo(1.1f);
		myObject.bar();
		myObject.foo(100000l,"No way my salary");
		
	}
}
