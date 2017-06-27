
public class MyClass
{
	// Just for fun let's also declare a static constant
	// Beware, pointcutting will not work on this attribute as it will be
	// 'inlined' when the Java compiler is through with it and so therefore
	// it will not exist or be accessed in the normal sense.
	public static final String CONSTANT = "CONSTANT STRING";

	// Two declared fields to exercise the access pointcut
	private int number;
	private String name;

	public String getName()
	{
		System.out.println("In the getName() method");
		return this.name;
	}

	public void setName(String name)
	{
		System.out.println("In the setName(String) method");
		this.name = name;
		System.out.println("The name field has been set");
	}

	public int getNumber()
	{
		System.out.println("In the getNumber() method");
		return this.number;
	}

	public void setNumber(int number)
	{
		System.out.println("In the setNumber(int) method");
		this.number = number;
		System.out.println("The number field has been set");
	}

	public static final void main(String args[])
	{
		// Create an instance of the object
		MyClass myObject = new MyClass();

		// Exercise all of the calls on the MyClass object
		System.out.println("Setting the name");
		myObject.setName("Russ Miles");
		System.out.println("The name has been set");

		System.out.println("Setting the number");
		myObject.setNumber(505499);
		System.out.println("The number has been set");
		System.out.println("Name Stored = " + myObject.getName());
		System.out.println("Number Stored = " + myObject.getNumber());

		System.out.println("The constant value is " + MyClass.CONSTANT);

	}
}
