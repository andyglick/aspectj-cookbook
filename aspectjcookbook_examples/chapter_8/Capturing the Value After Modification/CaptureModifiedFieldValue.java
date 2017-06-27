
public aspect CaptureModifiedFieldValue 
{
   pointcut setNamePointcut(String newValue) : set(String MyClass.name) && args(newValue);

   // Advice declaration
   before(String newValue) : setNamePointcut(newValue)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by " + "setNamePointcut()");
      System.out.println(
         "Signature: "
            + thisJoinPoint.getStaticPart().getSignature());
      System.out.println(
         "Source Line: "
            + thisJoinPoint.getStaticPart().getSourceLocation());
      
      System.out.println("Field Value set to: " + newValue);
      
      System.out.println(
         "------------------------------------------------------------");
   }
}
