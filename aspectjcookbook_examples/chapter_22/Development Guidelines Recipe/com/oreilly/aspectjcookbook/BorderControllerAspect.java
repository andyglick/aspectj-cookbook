package com.oreilly.aspectjcookbook;

public aspect BorderControllerAspect 
{
   /**
	* Specifies the testing region. 
	*/
   public pointcut withinTestingRegion() : within(com.oreilly.aspectjcookbook.testing.+);
   
   /**
	* Specifies My Applications region. 
	*/
   public pointcut withinMyApp() : within(com.oreilly.aspectjcookbook.myapp.+);
   
   /**
	* Specifies a third party source code region.
	*/
   public pointcut withinThirdParty() : within(com.oreilly.aspectjcookbook.thirdpartylibrary.+);
   
   /**
	* Specifies the applications main method.
	*/
   public pointcut withinMyAppMainMethod() : withincode(public void com.oreilly.aspectjcookbook.myapp.MyClass.main(..));
}
