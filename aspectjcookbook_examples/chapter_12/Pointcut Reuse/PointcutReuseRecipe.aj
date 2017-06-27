
/**
 * <p>Title: PointcutReuseRecipe aspect for Recipe 9.5</p>
 * <p>Description: Simple aspect for demonstrating defining, using,
 * and reusing named pointcuts</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect PointcutReuseRecipe 
{
   /*
   	A pointcut definition that is to be used and reused:
   	
   	Anonymous Pointcuts: call(void MyClass.foo(int,String)
   
   */
   pointcut foundationNamedPointcut() : call(
      void MyClass.foo(int, String));

   /*
   	A pointcut definition that is built up from two
   	pointcuts:
   	
   	Anonymous Pointcuts: !within(AnonymousPointcutRecipe +)
   	Named Pointcuts:	 foundationNamedPointcut()
   						
   */
   pointcut reuseNamedPointcut() : foundationNamedPointcut()
      && !within(PointcutReuseRecipe +);

   /*
   	A pointcut definition attached to the advice it will invoke,
   	built up from simple named and anonymous pointcuts: 
   	
   	Anonymous Pointcuts: !within(LogicalOrRecipe +)
   	Named Pointcuts: foundationNamedPointcut();
   */
   before() : foundationNamedPointcut()
      && !within(PointcutReuseRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by foundationNamedPointcut() and");
      System.out.println("!within(AnonymousPointcutRecipe() +");
      System.out.println(
         "Signature: " + thisJoinPoint.getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }

   /*
   	A pointcut definition attached to the advice it will invoke,
   	built up from complex pointcuts built reusing other pointcut
   	definitions: 
   	
   	Named Pointcuts: reuseNamedPointcut
   */
   before() : reuseNamedPointcut()
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by reuseNamedPointcut()");
      System.out.println(
         "Signature: " + thisJoinPoint.getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }
}
