
/**
 * <p>Title: TargetRecipe aspect for Recipe 8.2</p>
 * <p>Description: Simple aspect for demonstrating the 
 * target(TypePattern|Identifier) pointcut</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect TargetRecipe 
{
   /*
   	Specifies calling advice whenever the target of a methods
   	is of a type that matches the following rules:
   	
   	Type Pattern: AnotherClass
   */
   pointcut targetTypePatternAnotherClassPointcut() : target(AnotherClass);

   /*
   	Specifies calling advice whenever the target of a methods
   	is of a type that matches the following rules:
   
   	Identifier/s: MyClass object
   */
   pointcut targetIdentifierMyClassPointcut(MyClass object) : target(object);

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before() : targetTypePatternAnotherClassPointcut()
      && !within(TargetRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by targetTypePatternAnotherClassPointcut");
      System.out.println("Join Point Kind: " + thisJoinPoint.getKind());
      System.out.println(
         "Object referenced by Target: " + thisJoinPoint.getTarget());
      System.out.println(
         "Signature: " + thisJoinPoint.getStaticPart().getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getStaticPart().getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before(MyClass object) : targetIdentifierMyClassPointcut(object)
      && !within(TargetRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by targetIdentifierMyClassPointcut");
      System.out.println("Join Point Kind: " + thisJoinPoint.getKind());
      System.out.println("Object referenced by Target: " + object);
      System.out.println(
         "Signature: " + thisJoinPoint.getStaticPart().getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getStaticPart().getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }
}
