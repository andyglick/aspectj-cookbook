package com.oreilly.aspectjcookbook;

public class MyClass
{
   	private String property;
   	
   	public void foo()
   	{
   	   property = property + "changed: ";
   	}
   	
   	public String toString()
   	{
   	   return property;
   	}
}
