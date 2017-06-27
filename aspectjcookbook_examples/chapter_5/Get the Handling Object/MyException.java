
public class MyException extends Exception
{
	private String reasonWhy;

	public MyException(String reasonWhy, String message)
	{
		super(message);
		this.reasonWhy = reasonWhy;
	}

	public String toString()
	{
		return "Reason: "
			+ this.reasonWhy
			+ ", Message: "
			+ super.getMessage();
	}

	public String getMessage()
	{
		return this.toString();
	}

}
