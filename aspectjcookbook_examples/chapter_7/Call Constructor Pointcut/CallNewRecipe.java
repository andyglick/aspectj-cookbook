
public aspect CallNewRecipe 
{
   /*
   	Specifies calling advice when any constructor is called
   	that meets the following signature rules:
   
   	Class Name: MyClass
   	Method Name: new (This is a keyword indicating the constructor call)
   	Method Parameters: int, String
   */
   pointcut myClassConstructorWithIntAndStringPointcut() : call(
      MyClass.new (int, String));

   // Advice declaration
   before() : myClassConstructorWithIntAndStringPointcut()
   {
      System.out.println(
         "-------------- Aspect Advice Logic ---------------");
      System.out.println(
         "In the advice picked by "
            + "myClassConstructorWithIntAndOthersPointcut()");
      System.out.println(
         "The current type of object under construction is: ");
      System.out.println(thisJoinPoint.getThis());
      System.out.println(
         "Signature: "
            + thisJoinPoint.getSignature());
      System.out.println(
         "Source Line: "
            + thisJoinPoint.getSourceLocation());
      System.out.println(
         "--------------------------------------------------");
   }
}
