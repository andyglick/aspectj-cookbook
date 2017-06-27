
public aspect AccessHandlingObject 
{
   pointcut myExceptionHandlerPointcut(MyClass myObject) : handler(MyException) && this(myObject);

   // Advice declaration
   before(MyClass myObject) : myExceptionHandlerPointcut(myObject)
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
      
      System.out.println("Exception caught by:" + myObject);
      
      System.out.println(
         "--------------------------------------------------");
   }
}
