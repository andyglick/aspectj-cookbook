
package test.com.ourcompany;

import com.thirdparty.ThirdPartyComponentInterface;

public class MockThirdPartyComponent implements ThirdPartyComponentInterface {

	/* (non-Javadoc)
	 * @see com.thirdparty.ThirdPartyComponentInterface#bar()
	 */
	public void bar() 
	{
		System.out.println("Inside MockThirdPartyComponent.bar()");

	}
}
