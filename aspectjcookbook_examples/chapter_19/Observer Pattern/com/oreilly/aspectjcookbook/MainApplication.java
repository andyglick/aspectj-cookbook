package com.oreilly.aspectjcookbook;

public class MainApplication
{

	public static void main(String argv[])
	{
		ConcreteClassB b = new ConcreteClassB("Russell Miles", 10000.00f);

		ConcreteClassA a1 = new ConcreteClassA(1234567l);
		ConcreteClassA a2 = new ConcreteClassA(2345678l);
		
		b.addObserver(a1);
		b.addObserver(a2);

		System.out.println("Changing b's name:");

		b.setName("Kim");

		System.out.println("Changing b's wage:");

		b.setWage(1000000.00f);
    }
}
