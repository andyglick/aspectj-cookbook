
/**
 * <p>Title: AnonymousPointcutRecipe aspect for Recipe 9.4</p>
 * <p>Description: Simple aspect for demonstrating defining and using
 * anonymous pointcuts</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect AnonymousPointcutRecipe 
{
   /*
   	A pointcut definition that is built up from one
   	anonymous pointcut:
   	
   	Anonymous Pointcuts: call(void MyClass.foo(int,String)
   */
   pointcut singleAnonymousPointcut() : call(
      void MyClass.foo(int, String));

   /*
   	A pointcut definition that is built up from two
   	anonymous pointcuts:
   	
   	Anonymous Pointcuts: call(void MyClass.foo(int,String)
   					     call(void MyClass.foo(int,String)
   					     !within(AnonymousPointcutRecipe +)
   						
   */
   pointcut multipleAnonymousPointcut() : (
      call(void MyClass.bar())
         || call(void MyClass.foo(int, String))
         && !within(AnonymousPointcutRecipe +));

   /*
   	A pointcut definition attached to the advice it will invoke,
   	built up from anonymous pointcuts: 
   	
   	Anonymous Pointcuts: !within(LogicalOrRecipe +)
   */
   before() : singleAnonymousPointcut()
      && !within(AnonymousPointcutRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by singleAnonymousPointcut and");
      System.out.println("!within(AnonymousPointcutRecipe +");
      System.out.println(
         "Signature: " + thisJoinPoint.getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }

   /*
   	A pointcut definition attached to the advice it will invoke,
   	built up from anonymous pointcuts: 
   	
   	Anonymous Pointcuts: None
   */
   before() : multipleAnonymousPointcut()
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice picked by multipleAnonymousPointcut()");
      System.out.println(
         "Signature: " + thisJoinPoint.getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }
}
