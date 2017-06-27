/**
 * <p>Title: WithinClassRecipe aspect for Recipe 6.1</p>
 * <p>Description: Simple aspect for demonstrating advice 
 * on any join points within a specified class or classes scope</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect WithinClassRecipe 
{

   /*
   	Specifies calling advice on any join point is encountered within 
   	the defined scope:
   
   	Scope: MyClass
   */
   pointcut withinMyClass() : within(
      MyClass);

   // Advice declaration
   // This advice will be executed before the pointcut that picks it
   before() : withinMyClass() && !within(WithinClassRecipe +)
   {
      System.out.println(
         "-------------- Aspect Advice Logic ---------------");
      System.out.println(
         "In the advice picked by " + "withinMyClass()");
      System.out.println(
         "Join Point Kind: " + thisJoinPoint.getKind());
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