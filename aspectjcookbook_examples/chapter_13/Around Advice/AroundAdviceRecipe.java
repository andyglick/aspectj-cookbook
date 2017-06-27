/**
 * <p>Title: AroundAdvice aspect for Recipe 9.4</p>
 * <p>Description: Simple aspect for demonstrating the use of around advice.</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect AroundAdviceRecipe 
{
   /*
   	Specifies calling advice whenever a method
   	matching the following rules gets called:
   
   	Class Name: MyClass
   	Method Name: bar
   	Method Return Type: int
   	Method Parameters: 
   	*/
   pointcut callFooPointCut() : call(int MyClass.foo());

   /*
    Specifies calling advice whenever a method
    matching the following rules gets called:
   
    Class Name: MyClass
    Method Name: bar2
    Method Return Type: int
    Method Parameters: int
    */
   pointcut callBarPointCut(int value) : call(int MyClass.bar(int))
      && args(value);
   
   /*
  	Specifies calling advice whenever a method
  	matching the following rules gets called:
  
  	Class Name: MyClass
  	Method Name: baz
  	Method Return Type: int
  	Method Parameters: 
  	*/
   pointcut callBazPointCut() : call(int MyClass.baz());

    // Advice declaration
	// This advice will be executed before the pointcut that picks it
   int around() : callFooPointCut() && !within(AroundAdviceRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "Signature: " + thisJoinPoint.getSignature());
      System.out.println(
         "Source Location: "
            + thisJoinPoint.getStaticPart().getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
      return proceed();
   }

    // Advice declaration
	// This advice will be executed before the pointcut that picks it
   int around(int value) : callBarPointCut(value)
      && !within(AroundAdviceRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "Signature: " + thisJoinPoint.getSignature());
      System.out.println(
         "Source Location: "
            + thisJoinPoint.getStaticPart().getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
      return proceed(value);
   }
   
   // Advice declaration
   // This advice will be executed before the pointcut that picks it
  int around() : callBazPointCut() && !within(AroundAdviceRecipe +)
  {
     System.out.println(
        "------------------- Aspect Advice Logic --------------------");
     System.out.println(
        "Signature: " + thisJoinPoint.getSignature());
     System.out.println(
        "Source Location: "
           + thisJoinPoint.getStaticPart().getSourceLocation());
     System.out.println(
        "------------------------------------------------------------");
     return 200;
  }
}
