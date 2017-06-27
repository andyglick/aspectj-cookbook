package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.PackageA.BusinessLogicClass2;
import com.oreilly.aspectjcookbook.PackageA.BusinessException;

public class MainApplication 
{

	public static void main(String[] args) 
	{
		// Create an instance of the Business Logic class
		BusinessLogicClass1 businessLogicObject1 = new BusinessLogicClass1();
		BusinessLogicClass2 businessLogicObject2 = new BusinessLogicClass2();
		
		// Run a couple of methods on the Business Logic class
		businessLogicObject1.foo();
		businessLogicObject1.bar();
		try
		{
			businessLogicObject2.foo();
		}
		catch(BusinessException be)
		{
			System.err.println("Business exception caught");
		}
		businessLogicObject2.bar();
		
	}
}
