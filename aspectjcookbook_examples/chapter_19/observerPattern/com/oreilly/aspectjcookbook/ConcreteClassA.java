package com.oreilly.aspectjcookbook;

public class ConcreteClassA
{
	private long pin;

	public ConcreteClassA(long pin)
	{
		this.pin = pin;
	}

	public void doSomething(String s)
	{
		System.out.println(this.pin + ": " + s);
	}
}
