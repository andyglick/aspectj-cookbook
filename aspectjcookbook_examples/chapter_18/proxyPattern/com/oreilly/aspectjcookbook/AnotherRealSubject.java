package com.oreilly.aspectjcookbook;

public class AnotherRealSubject
{  
	public static void print(String s) 
	{
		System.out.println("[AnotherRealSubject.print:] "+s);
	}

	public static void write(String s) 
	{
		System.out.println("[AnotherRealSubject.write:] "+s);
	}
}