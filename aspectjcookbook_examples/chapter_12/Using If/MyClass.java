
public class MyClass
{
	private long salary;
	private String name;

	public long getSalary()
	{
		return this.salary;
	}

	public void setSalary(long salary)
	{
		this.salary = salary;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public static final void main(String args[])
	{
		// Create instances of the objects
		MyClass myObject = new MyClass();
		
		myObject.setName("Adam");
		
		myObject.setSalary(100000l);
		
		myObject.setName("Andy");
		
		myObject.setSalary(25000l);
		
		myObject.setName("Bobs");
		
		myObject.setSalary(19000l);
	}
}
