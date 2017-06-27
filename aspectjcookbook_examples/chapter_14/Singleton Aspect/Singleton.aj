
/**
 * <p>Title: Singleton aspect for Recipe 11.1</p>
 * <p>Description: Simple aspect for demonstrating the that an aspect can be delared as a singleton</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect Singleton issingleton()
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
   before() : callPointCut() && !within(Singleton +)
   {

      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice attached to the call point cut");
      System.out.println(
         "Target: " + thisJoinPoint.getTarget());
      System.out.println(
         "This: " + thisJoinPoint.getThis());
      System.out.println("Aspect Instance: " + Singleton.aspectOf());
      System.out.println(
         "------------------------------------------------------------");

   }
}
