
public aspect AdviceExecutionRecipe 
{
   /*
   	Specifies calling advice whenever advice is executed
   */
   pointcut adviceExecutionPointcut() : adviceexecution();

   // Advice declaration
   before() : adviceExecutionPointcut()
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
