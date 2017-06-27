
public aspect AccessThrownException 
{
   pointcut myExceptionHandlerPointcut(MyException exception) : handler(MyException) && args(exception);

   // Advice declaration
   before(MyException exception) : myExceptionHandlerPointcut(exception)
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
      
      System.out.println("Exception caught:");
      exception.printStackTrace();
      
      System.out.println(
         "--------------------------------------------------");
   }
}
