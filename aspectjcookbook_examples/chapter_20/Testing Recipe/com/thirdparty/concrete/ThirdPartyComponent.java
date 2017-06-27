package com.thirdparty.concrete;

import com.thirdparty.ThirdPartyComponentInterface;

public class ThirdPartyComponent implements ThirdPartyComponentInterface 
{
	public void bar()
	{
		System.out.println("Inside ThirdPartyComponent.bar() concrete method");
	}
}
