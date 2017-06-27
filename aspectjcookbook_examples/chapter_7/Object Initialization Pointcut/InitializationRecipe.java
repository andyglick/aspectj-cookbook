
public aspect InitializationRecipe 
{
   /*
   	Specifies calling advice when any object 
   	initializes using a constructor
   	that meets the following signature rules:
   
   	Class Name: MyClass
   	Method Name: new (This is a keyword indicating the 
   	                  constructor call)
   	Method Parameters: int and any others
   */
   pointcut myClassObjectInitializationWithIntAndOthersPointcut() : initialization(
      MyClass.new (int, *));

   // Advice declaration
   before() : myClassObjectInitializationWithIntAndOthersPointcut()
   {
      System.out.println(
         "-------------- Aspect Advice Logic ---------------");
      System.out.println(
         "In the advice picked by "
            + "myClassObjectInitializationWithIntAndOthersPointcut()");
      System.out.println(
         "The current type of object under construction is: ");
      System.out.println(thisJoinPoint.getThis().getClass());
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
