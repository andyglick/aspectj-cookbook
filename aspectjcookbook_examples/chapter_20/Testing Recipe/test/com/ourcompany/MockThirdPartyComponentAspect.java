package test.com.ourcompany;

import com.thirdparty.*;

public aspect MockThirdPartyComponentAspect 
{
	public pointcut catchThirdPartyConstructor() : 
	   call(ThirdPartyComponentInterface ThirdPartyComponentFactory.
	         getThirdPartyComponent());
	
	Object around() : catchThirdPartyConstructor()
	{
		return new MockThirdPartyComponent();
	}
}
