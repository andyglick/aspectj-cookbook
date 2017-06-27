
public aspect GetConstant 
{
   /*
  	Specifies calling advice whenever an attribute 
  	matching the following rules is accessed.
  	
  	Type: String
  	Class Name: MyClass
  	Attribute Name: CONSTANT
  */
  pointcut getConstantPointcut() : get(
     public static final String MyClass.CONSTANT);
  
  // Advice declaration
  before() : getConstantPointcut()
  {
     System.out.println(
        "-------------- Aspect Advice Logic ---------------");
     System.out.println(
        "In the advice picked by " + "getConstantPointcut()");
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
