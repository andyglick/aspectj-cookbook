
public aspect StaticInitializationRecipe 
{
   /*
   	Specifies calling advice when a class is intialized
   	that meets the following type pattern rules:
   
   	Class Name: MyClass
   */
   pointcut myClassStaticInitializationPointcut() : staticinitialization(MyClass);

   // Advice declaration
   before() : myClassStaticInitializationPointcut()
   {
      System.out.println(
         "-------------- Aspect Advice Logic ---------------");
      System.out.println(
         "In the advice picked by "
            + "myClassStaticInitializationPointcut()");
      System.out.println(
         "Join Point Kind: "
            + thisJoinPoint.getStaticPart().getKind());
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