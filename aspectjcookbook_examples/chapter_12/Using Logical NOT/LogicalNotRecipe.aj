
/**
 * <p>Title: PointcutReuseRecipe aspect for Recipe 9.6</p>
 * <p>Description: Simple aspect for demonstrating negation of
 * pointcut logic</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect LogicalNotRecipe 
{
   /*
   	Specifies calling advice whenever a method 
   	does NOT match the following rules 
   	gets called:
   	
   	Class Name: MyClass
   	Method Name: foo
   	Method Return Type: void
   	Method Parameters: an int followed by a String
   */
   pointcut notCallPointCutFooIntString() : !call(
      void MyClass.foo(int, String));

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before() : notCallPointCutFooIntString()
      && !within(LogicalNotRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by notCallPointCutFooIntStringAnyReturn()");
      System.out.println(
         "Signature: " + thisJoinPoint.getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }
}
