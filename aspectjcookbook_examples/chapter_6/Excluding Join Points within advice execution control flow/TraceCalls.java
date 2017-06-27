
public aspect TraceCalls 
{
   /*
   	Specifies calling advice when not within any aspects in the application.
   */
   /*
   pointcut tracedCalls() : call(* *.*(..)) && 
      !within(TraceCalls+) &&
      !within(CallRecipe+);
   */
   pointcut tracedCalls() : call(* *.*(..)) && 
      !within(TraceCalls+) &&
      !within(CallRecipe+) &&
      !cflow(adviceexecution());
   

   // Advice declaration
   before() : tracedCalls()
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println("In the advice picked by TraceCalls");
      
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
