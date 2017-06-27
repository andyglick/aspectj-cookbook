
/**
 * <p>Title: WithinPackageRecipe aspect for Recipe 6.2</p>
 * <p>Description: Simple aspect for demonstrating advice 
 * on any join points within a specified packages</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect WithinPackageRecipe 
{
   /*
   	Specifies calling advice on any join point is encountered within 
   	the defined scope:
   
   	Scope: packageA
   */
   pointcut withinPackageA() : within(packageA.*);

   // Advice declaration
   // This advice will be executed before the pointcut that picks it
   before() : withinPackageA() && !within(WithinPackageRecipe +)
   {
      System.out.println("-------------- Aspect Advice Logic ---------------");
      System.out.println("In the advice picked by " + "withinPackageA()");
      System.out.println("Join Point Kind: " + thisJoinPoint.getKind());
      System.out.println("Signature: " + thisJoinPoint.getStaticPart().getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getStaticPart().getSourceLocation());
      System.out.println("--------------------------------------------------");
   }
}