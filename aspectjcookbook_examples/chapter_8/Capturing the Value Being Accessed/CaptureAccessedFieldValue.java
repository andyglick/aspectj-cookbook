
public aspect CaptureAccessedFieldValue 
{
   pointcut getNamePointcut() : get(String MyClass.name);

   // Advice declaration
   after() returning(String value) : getNamePointcut()
   {
      System.out.println(
         "-------------- Aspect Advice Logic ---------------");
      System.out.println(
         "In the advice picked by " + "getNamePointcut()");
      System.out.println(
         "Signature: "
            + thisJoinPoint.getStaticPart().getSignature());
      System.out.println(
         "Source Line: "
            + thisJoinPoint.getStaticPart().getSourceLocation());
      
      System.out.println("Value being access is " + value);
      
      System.out.println(
         "--------------------------------------------------");
   }
}
