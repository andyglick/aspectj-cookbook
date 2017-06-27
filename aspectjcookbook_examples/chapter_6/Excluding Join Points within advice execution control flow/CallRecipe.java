public aspect CallRecipe 
{
	/*
	Specifies calling advice whenever a method
	matching the following rules gets called:
	
	Class Name: MyClass
	Method Name: foo
	Method Return Type: * (any return type)
	Method Parameters: an int followed by a String
	*/
	pointcut callPointCut() : call(void MyClass.foo(int, String));

	// Advice declaration
	before() : callPointCut()
	{

		System.out.println(
			"------------------- Aspect Advice Logic --------------------");
		System.out.println("In the advice attached to the call point cut");
		
		System.out.println(
				"Signature: " + thisJoinPoint.getStaticPart().getSignature());
		System.out.println(
		      "Source Line: "
		      + thisJoinPoint.getStaticPart().getSourceLocation());
		
		AnotherClass anotherClass = new AnotherClass();
		anotherClass.foo();
		
		System.out.println(
			"------------------------------------------------------------");

	}
}
