/**
 * <p>Title: ExtendAspectRecipe aspect for Recipe 12.1</p>
 * <p>Description: Simple aspect for demonstrating the ability to reuse pointcuts by extending aspects</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect ReusePointcutsRecipe
   extends BasePointcutDefinitionsAspect 
{

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before() : callPointcut() && !within(ReusePointcutsRecipe +)
   {

      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice attached to the call point cut");
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
