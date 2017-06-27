
public aspect ExecutionRecipe 
{
   /*
   	Specifies calling advice whenever a method 
   	matching the following rules enters execution:
   	
   	Class Name: MyClass
   	Method Name: foo
   	Method Return Type: int
   	Method Parameters: an int followed by a String
   */
   pointcut executionPointcut() : execution(
      void MyClass.foo(int, String));

   // Advice declaration
   before() : executionPointcut()
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println("In the advice picked by ExecutionRecipe");
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
