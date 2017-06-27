package com.oreilly.aspectjcookbook.PackageA;

public class BusinessLogicClass2 
{
	public void foo() throws BusinessException
	 {
	 	throw new BusinessException();
	 }
	 
	 public void bar()
	 {
	 	try
		{
	 		this.foo();
		}
	 	catch(BusinessException be)
		{
	 		System.err.println("Business Exception caught");
		}
	 }
}
