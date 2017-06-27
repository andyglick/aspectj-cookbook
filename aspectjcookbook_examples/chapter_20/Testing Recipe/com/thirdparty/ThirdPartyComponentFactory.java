package com.thirdparty;

import com.thirdparty.concrete.ThirdPartyComponent;

public class ThirdPartyComponentFactory 
{
	public static ThirdPartyComponentInterface getThirdPartyComponent()
	{
		return new ThirdPartyComponent();
	}
}
