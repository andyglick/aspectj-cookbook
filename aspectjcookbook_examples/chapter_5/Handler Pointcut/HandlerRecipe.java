
public aspect HandlerRecipe 
{
   /*
   	Specifies calling advice when any exception object is thrown
   	that matches the following rules for its type pattern:
   
   	Type: MyException
   */
   pointcut myExceptionHandlerPointcut() : handler(MyException);

   // Advice declaration
   before() : myExceptionHandlerPointcut()
   {
      System.out.println(
         "-------------- Aspect Advice Logic ---------------");
      System.out.println(
         "In the advice picked by " + "myExceptionHandlerPointcut()");
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
