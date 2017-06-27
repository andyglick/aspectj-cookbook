
public class MainClass 
{
	public static void main(String[] args)
	{
	   // Create an instance of MyClass
	   MyClass myObject = new MyClass();

	   System.out.println(
	      "Returned value from foo: " + myObject.foo());

	   System.out.println(
	      "Returned value from bar: " + myObject.bar(20));
	      
	   System.out.println(
	      "Returned value from baz: " + myObject.baz());
	}
}
