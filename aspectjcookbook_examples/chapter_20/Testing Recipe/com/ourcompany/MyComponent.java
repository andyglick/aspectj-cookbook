package com.ourcompany;

import com.thirdparty.ThirdPartyComponentFactory;
import com.thirdparty.ThirdPartyComponentInterface;

public class MyComponent implements MyComponentInterface
{
	private ThirdPartyComponentInterface thirdPartyComponent;
	
	public MyComponent()
	{
		this.thirdPartyComponent = ThirdPartyComponentFactory.getThirdPartyComponent();
		System.out.println("Component found " + thirdPartyComponent);
	}
	
	public void foo()
	{
		System.out.println("Inside MyComponent.foo()");
		this.thirdPartyComponent.bar();
	}
}
