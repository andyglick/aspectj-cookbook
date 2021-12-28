package com.oreilly.aspectjcookbook; 

public class RealSubject 
{
	public void print(String s) 
	{
		System.out.println("[RealSubject.print:] "+s);
	}

	public void write(String s) 
	{
		System.out.println("[RealSubject.write:] "+s);
	}
}