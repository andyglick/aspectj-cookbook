
/**
 * <p>Title: WithinMethodRecipe aspect for Recipe 6.3</p>
 * <p>Description: Simple aspect for demonstrating the 
 * withincode(Signature) pointcut</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect WithinMethodRecipe 
{
   /*
   	Specifies calling advice whenever a method 
   	matching the following rules gets called:
   	
   	Class Name: MyClass
   	Method Name: foo
   	Method Return Type: * (any return type)
   	Method Parameters: an int followed by a String
   */
   pointcut withinFooIntStringAnyReturnPointcut() : withincode(
      * MyClass.foo(int, String));

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before() : withinFooIntStringAnyReturnPointcut()
      && !within(WithinMethodRecipe +)
   {
      System.out.println(
         "-------------- Aspect Advice Logic ---------------");
      System.out.println(
         "In the advice picked by withinFooIntStringAnyReturnPointcut");
      System.out.println(
         "Join Point Kind: "
            + thisJoinPoint.getStaticPart().getKind());
      System.out.println(
         "Signature: "
            + thisJoinPoint.getStaticPart().getSignature());
      System.out.println(
         "Source Line: "
            + thisJoinPoint.getStaticPart().getSourceLocation());
      System.out.println(
         "--------------------------------------------------");
   }
}
