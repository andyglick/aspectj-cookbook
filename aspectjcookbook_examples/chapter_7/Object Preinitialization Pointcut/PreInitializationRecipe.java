
public aspect PreInitializationRecipe 
{
   /*
   	Specifies calling advice just before an object initializes using a constructor
   	that meets the following signature rules:
   
   	Class Name: MyClass
   	Method Name: new (This is a keyword indicating the constructor call)
   	Method Parameters: Any Parameters
   */
   pointcut myClassIntStringObjectPreInitializationPointcut() : preinitialization(
      MyClass.new (int, String));

   // Advice declaration
   before(
      int number,
      String name) : myClassIntStringObjectPreInitializationPointcut()
      && args(number, name)
   {
      System.out.println(
         "-------------- Aspect Advice Logic ---------------");
      System.out.println(
         "In the advice picked by "
            + "anyMyClassObjectInitializationPointcut()");
      System.out.println(
         "The current type of object under construction is: ");
      System.out.println(thisJoinPoint.getThis());
      System.out.println(
         "The values passed in were: " + number + ", " + name);
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
