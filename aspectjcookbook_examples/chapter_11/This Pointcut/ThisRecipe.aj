/**
 * <p>Title: ThisRecipe aspect for Recipe 8.1</p>
 * <p>Description: Simple aspect for demonstrating the 
 * this(TypePattern|Identifier) pointcut</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect ThisRecipe 
{
   /*
   	Specifies calling advice whenever the executing
   	object is of a type that matches the following rules:
   	
   	Identifier/s: MyClass object
   */
   pointcut thisIdentifierMyClassPointcut(MyClass object) : this(object);

   /*
       Specifies calling advice whenever the executing
   	object is of a type that matches the following rules:
   	
   	Type Pattern: AnotherClass
   */
   pointcut thisTypePatternAnotherClassPointcut() : this(AnotherClass);

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before(MyClass object) : thisIdentifierMyClassPointcut(object)
      && !within(ThisRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by thisIdentifierMyClassPointcut");
      System.out.println("Join Point Kind: " + thisJoinPoint.getKind());
      System.out.println(
         "Type of executing object: " + object.getClass().getName());
      System.out.println(
         "Object referenced by this: " + thisJoinPoint.getThis());
      System.out.println(
         "Signature: " + thisJoinPoint.getStaticPart().getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getStaticPart().getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }

   //	Advice declaration
   //This advice will be executed before the pointcut that picks it
   before() : thisTypePatternAnotherClassPointcut() && !within(ThisRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by thisTypePatternAnotherClassPointcut");
      System.out.println("Join Point Kind: " + thisJoinPoint.getKind());
      System.out.println(
         "Type of executing object: "
            + thisJoinPoint.getThis().getClass().getName());
      System.out.println(
         "Object referenced by this: " + thisJoinPoint.getThis());
      System.out.println(
         "Signature: " + thisJoinPoint.getStaticPart().getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getStaticPart().getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }
}
