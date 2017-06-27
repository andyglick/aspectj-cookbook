package com.oreilly.aspectjcookbook;

public class MainApplication
{
	public MainApplication()
	{
		RealSubject real = new RealSubject();

		real.print("PRINT");
		real.write("WRITE");
		real.print("PRINT");
		real.write("WRITE");
	}

	public static void main(String[] args)
	{
		MainApplication application = new MainApplication();
		
		RealSubject real = new RealSubject();

		real.print("PRINT");
		real.write("WRITE");
	}
}
