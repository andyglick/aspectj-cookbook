
public aspect GetRecipe 
{

   /*
   	Specifies calling advice whenever an attribute 
   	matching the following rules is accessed:
   	
   	Type: String
   	Class Name: MyClass
   	Attribute Name: name
   */
   pointcut getNamePointcut() : get(String MyClass.name);

   // Advice declaration
   before() : getNamePointcut()
   {
      System.out.println(
         "-------------- Aspect Advice Logic ---------------");
      System.out.println(
         "In the advice picked by " + "getNamePointcut()");
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
