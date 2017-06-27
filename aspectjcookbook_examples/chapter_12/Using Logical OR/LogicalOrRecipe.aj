/**
 * <p>Title: LogicalOrRecipe aspect for Recipe 9.3</p>
 * <p>Description: Simple aspect for demonstrating combining
 * pointcuts using the logical OR operator</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect LogicalOrRecipe 
{
   /*
   	Specifies calling advice whenever a method 
   	matching the following rules gets called:
   	
   	Class Name: MyClass
   	Method Name: foo
   	Method Return Type: void
   	Method Parameters: int and a String
   */
   pointcut callFooIntStringPointcut() : call(
      void MyClass.foo(int, String));

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
   	
   	Pointcut name: callFooIntStringPointcut
   	Pointcut name: callBarPointcut
   	Method Return Type: void
   	Method Parameters: None
   */
   pointcut callIntersectionFooOrBar() : callFooIntStringPointcut()
      || callBarPointcut();

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before() : callFooIntStringPointcut()
      && !within(LogicalOrRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by callFooIntStringPointcut");
      System.out.println(
         "Signature: " + thisJoinPoint.getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before() : callBarPointcut() && !within(LogicalOrRecipe +)
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
   before() : callIntersectionFooOrBar()
      && !within(LogicalOrRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by callIntersectionFooOrBar");
      System.out.println(
         "Signature: " + thisJoinPoint.getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }
}
