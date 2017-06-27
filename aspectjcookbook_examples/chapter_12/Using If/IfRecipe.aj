/**
 * <p>
 * Title: IfRecipe aspect for Recipe 9.1
 * </p>
 * <p>
 * Description: Simple aspect for demonstrating the if(BooleanExpr) pointcut
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003 Russell Miles
 * </p>
 * 
 * @author Russell Miles
 * @version 1.0
 */

public aspect IfRecipe 
{
   // Define some variables for comparison
   private static final long realisticSalary = 30000l;

   /*
    * Specifies calling advice if this is referencing an object of class MyClass
    * and the object has a realistic salary:
    */
   pointcut ifJoinPointThisHasRealisticSalaryPointcut() : if (
      thisJoinPoint.getThis() instanceof MyClass
         && ((MyClass) thisJoinPoint.getThis()).getSalary()
            < realisticSalary
         && ((MyClass) thisJoinPoint.getThis()).getSalary() > 0)
      && !withincode(* MyClass.get*());

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   after() : ifJoinPointThisHasRealisticSalaryPointcut()
      && !within(IfRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by ifJoinPointThisHasRealisticSalaryPointcut");
      System.out.println(
         "Join Point Kind: " + thisJoinPoint.getKind());
      System.out.println(
         "Executing object: " + thisJoinPoint.getThis());
      System.out.println(
         "MyClass instance: "
            + ((MyClass) thisJoinPoint.getThis()).getName()
            + " : "
            + ((MyClass) thisJoinPoint.getThis()).getSalary());
      System.out.println(
         "Signature: " + thisJoinPoint.getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }
}
