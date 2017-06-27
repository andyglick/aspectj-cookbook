/**
 * <p>Title: ArgsRecipe aspect for Recipe 8.3</p>
 * <p>Description: Simple aspect for demonstrating the 
 * args(TypePattern|Identifier,..) pointcut</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect ArgsRecipe 
{
   /*
   	Specifies calling advice whenever the type of a methods argument 
   	is of a type that matches the following rules:
   
   	Identifier/s: MyClass object
   */
   pointcut argIdentifierMyClassPointcut(MyClass object) : args(object);

   /*
   	Specifies calling advice whenever the type of a methods argument 
   	is of a type that matches the following rules:
   	
   	Type Pattern: AnotherClass
   */
   pointcut argTypePatternAnotherClassPointcut() : args(AnotherClass);

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before(MyClass object) : argIdentifierMyClassPointcut(object)
      && !within(ArgsRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by argIdentifierMyClassPointcut");
      System.out.println("Join Point Kind: " + thisJoinPoint.getKind());
      System.out.println(
         "Signature: " + thisJoinPoint.getStaticPart().getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getStaticPart().getSourceLocation());
      System.out.println(
            "Arguments picked up using Identifiers: " + object);
      System.out.println(
         "------------------------------------------------------------");
   }

   //	Advice declaration
   // This advice will be executed before the pointcut that picks it
   before() : argTypePatternAnotherClassPointcut() && !within(ArgsRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by argTypePatternAnotherClassPointcut");
      System.out.println("Join Point Kind: " + thisJoinPoint.getKind());
      System.out.println(
         "Signature: " + thisJoinPoint.getStaticPart().getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getStaticPart().getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }
}
