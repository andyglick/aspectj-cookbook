/**
 * <p>Title: ThisJoinPointRecipe aspect for Recipe 10.2</p>
 * <p>Description: Simple aspect for demonstrating the information available from the thisJoinPoint context variable.</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect ThisJoinPointRecipe 
{
   /*
   Specifies calling advice whenever a method
   matching the following rules gets called:
   
   Class Name: MyClass
   Method Name: foo
   Method Return Type: * (any return type)
   Method Parameters: an int followed by a String
   */
   pointcut callPointCut() : call(void MyClass.foo(int, String));

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before() : callPointCut() && !within(ThisJoinPointRecipe +)
   {

      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "Exercising the static parts of AspectJ 1.1.1 thisJoinPoint");
      System.out.println(
         "Source Line: "
            + thisJoinPointStaticPart.getSourceLocation());
      System.out.println(
         "Join Point Kind: "
            + thisJoinPointStaticPart.getKind());
      System.out.println(
         "Simple toString: "
            + thisJoinPointStaticPart.toString());
      System.out.println(
         "Simple toShortString: "
            + thisJoinPointStaticPart.toShortString());
      System.out.println(
         "Simple toLongString: "
            + thisJoinPointStaticPart.toLongString());
      System.out.println(
         "Exercising the join point generic signature of AspectJ 1.1.1 thisJoinPoint");
      System.out.println(
         "Signature: "
            + thisJoinPointStaticPart.getSignature());
      System.out.println(
         "Signature name: "
            + thisJoinPointStaticPart.getSignature().getName());
      System.out.println(
         "Signature declaring type: "
            + thisJoinPointStaticPart.getSignature().getDeclaringType());
      System.out.println(
         "------------------------------------------------------------");
   }

   //	Advice declaration
   //This advice will be executed before the pointcut that picks it
   before() : callPointCut() && !within(ThisJoinPointRecipe +)
   {

      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "Exercising the dynamic parts of AspectJ 1.1.1 thisJoinPoint");
      System.out.println(
         "Get the this reference: " + thisJoinPoint.getThis());
      System.out.println(
         "Getting the Target: " + thisJoinPoint.getTarget());
      System.out.println("Join Point Arguments: ");
      Object[] args = thisJoinPoint.getArgs();
      for (int count = 0; count < args.length; count++)
      {
         System.out.println(args[count]);
      }
      System.out.println(
         "------------------------------------------------------------");
   }
}
