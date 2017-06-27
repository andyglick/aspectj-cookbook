package com.oreilly.aspectjcookbook;

public class MainApplication 
{

	public static void main(String[] args) 
	{
		// Create an instance of the Business Logic class
		BusinessLogicClass businessLogicObject = new BusinessLogicClass();
		
		// Run a couple of methods on the Business Logic class
		businessLogicObject.foo();
		businessLogicObject.bar();
	}
}
