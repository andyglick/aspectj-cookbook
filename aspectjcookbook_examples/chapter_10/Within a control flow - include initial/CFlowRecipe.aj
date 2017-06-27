/**
 * <p>Title: CFlowRecipe aspect for Recipe 7.1</p>
 * <p>Description: Simple aspect for demonstrating the cflow(pointcut) pointcut</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect CFlowRecipe 
{
   /*
   Specifies calling advice whenever a method
   matching the following rules gets called:
   
   Class Name: MyClass
   Method Name: foo
   Method Return Type: * (any return type)
   Method Parameters: an int followed by a String
   */
   pointcut callInitialPointcut() : call(
      void MyClass.foo(int, String));

   /*
   	Specifies calling advice whenever a join point is encountered
   	including and after the join point that triggers the pointcut
   	that is specified in the parameter:
   
   	Pointcut Name: callInitialPointcut
   */
   pointcut cflowPointcut() : cflow(callInitialPointcut());

   // Advice declaration
   // This advice will be executed before the pointcut that picks it
   before() : cflowPointcut() && !within(CFlowRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice attached to the cflowPointcut point cut");
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
         "------------------------------------------------------------");
   }
}
