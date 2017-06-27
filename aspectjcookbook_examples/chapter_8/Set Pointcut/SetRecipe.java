
public aspect SetRecipe 
{

   /*
   	Specifies calling advice whenever an attribute 
   	matching the following rules is modified:
   
   	Type: String
   	Class Name: MyClass
   	Attribute Name: name
   */
   pointcut setNamePointcut() : set(String MyClass.name);

   // Advice declaration
   before() : setNamePointcut()
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by " + "setNamePointcut()");
      System.out.println(
         "Signature: "
            + thisJoinPoint.getStaticPart().getSignature());
      System.out.println(
         "Source Line: "
            + thisJoinPoint.getStaticPart().getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }
}
