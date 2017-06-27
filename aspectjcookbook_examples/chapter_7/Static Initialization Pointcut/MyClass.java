
public class MyClass
{
	public static final int constant = 1;
	private static int count = 0;
	private static String authorName;
	private String name;

	// Static initialization block
	static {
		System.out.println(
			"Setting up the author name in " + "a static initialization block");
		authorName = "Russ Miles";
		System.out.println("Static initialization of author name completed");
	}

	public MyClass()
	{
		this.name = "MyClass again";
		count++;
	}

	// The MyClass class is loaded for use.
	// Static initialization pointcuts that specify MyClass
	// are triggered at this point
	public static final void main(String args[])
	{
		// Create an instance of the object
		MyClass myObject = new MyClass();
	}
}
