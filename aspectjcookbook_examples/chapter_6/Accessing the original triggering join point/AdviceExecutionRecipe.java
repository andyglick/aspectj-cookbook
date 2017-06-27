
import org.aspectj.lang.JoinPoint;

public aspect AdviceExecutionRecipe 
{
   /*
   	Specifies calling advice whenever advice is executed
   */
   pointcut adviceExecutionPointcut(JoinPoint originalJoinPoint) : adviceexecution() && args(originalJoinPoint) && !within(AdviceExecutionRecipe);

   // Advice declaration
   before(JoinPoint originalJoinPoint) : adviceExecutionPointcut(originalJoinPoint)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println("In the advice picked by AdviceExecutionRecipe");
      System.out.println(
         "Signature: "
            + thisJoinPoint.getStaticPart().getSignature());
      System.out.println(
         "Source Line: "
            + thisJoinPoint.getStaticPart().getSourceLocation());
      
      System.out.println(
            "Advised Advice's Join Point Signature: "
               + originalJoinPoint.getSignature());
      
      System.out.println(
         "------------------------------------------------------------");
   }
}
