public class MyClass
{

	public MyClass clone(MyClass object)
	{
		MyClass newObject = new MyClass();

		return newObject;
	}

	public void passAnother(AnotherClass another)
	{
		System.out.println(
			"Inside constructional method MyClass.passAnother(AnotherClass another) with: " + another);
	}

	public static final void main(String args[])
	{
		// Create instances of the objects
		MyClass myObject = new MyClass();
		AnotherClass anotherObject = new AnotherClass();

		MyClass anotherMyClass = myObject.clone(myObject);
	
		myObject.passAnother(anotherObject);
	}
}
