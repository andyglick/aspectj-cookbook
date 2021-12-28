package com.oreilly.aspectjcookbook;

public class Manager
{
	Object container;
	
	public void add(Object object)
	{
		this.container = object;
	}
}
