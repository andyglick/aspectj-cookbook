package test.com.ourcompany;

import com.ourcompany.MyComponent;
import com.ourcompany.MyComponentInterface;

import junit.framework.TestCase;

public class MyComponentTest extends TestCase 
{
	public void testFoo() 
	{
		MyComponentInterface myComponent = new MyComponent();
		myComponent.foo();
	}
}
