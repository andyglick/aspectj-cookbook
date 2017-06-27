/**
 * <p>Title: LogicalAndRecipe aspect for Recipe 9.2</p>
 * <p>Description: Simple aspect for demonstrating combining
 * pointcuts using the logical AND operator</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect LogicalAndRecipe 
{
   /*
   	Specifies calling advice whenever a method 
   	matching the following rules gets called:
   	
   	Class Name: MyClass
   	Method Name: Any Method
   	Method Return Type: Any Return Type
   	Method Parameters: Any Parameters
   */
   pointcut callAnyMethodOnMyClass() : call(* MyClass.* (..));

   /*
   	Specifies calling advice whenever a method 
   	matching the following rules gets called:
   	
   	Class Name: MyClass
   	Method Name: bar
   	Method Return Type: void
   	Method Parameters: None
   */
   pointcut callBarPointcut() : call(void MyClass.bar());

   /*
   	Specifies calling advice whenever a join points is
   	encountered that would be picked by both pointcuts
   	specified:
   	
   	Pointcut name: callAnyMethodOnMyClass
   	Pointcut name: callBarPointcut
   	Method Return Type: void
   	Method Parameters: None
   */
   pointcut callIntersectionAnyAndBar() : callAnyMethodOnMyClass()
      && callBarPointcut();

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before() : callAnyMethodOnMyClass() && !within(LogicalAndRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by callAnyMethodOnMyClass");
      System.out.println(
         "Signature: " + thisJoinPoint.getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before() : callBarPointcut() && !within(LogicalAndRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println("In the advice picked by callBarPointcut");
      System.out.println(
         "Signature: " + thisJoinPoint.getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before() : callIntersectionAnyAndBar()
      && !within(LogicalAndRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by callIntersectionAnyAndBar");
      System.out.println(
         "Signature: " + thisJoinPoint.getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }
}
