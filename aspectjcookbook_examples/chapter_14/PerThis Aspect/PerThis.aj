/**
 * <p>Title: PerThis aspect for Recipe 11.2</p>
 * <p>Description: Simple aspect for demonstrating the that an aspect can be delared for instantiation on a per this basis</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect PerThis perthis(callPointCut())
{
   /*
   Specifies calling advice whenever a method
   matching the following rules is executed:
   
   Class Name: MyClass
   Method Name: foo
   Method Return Type: * (any return type)
   Method Parameters: an int followed by a String
   */
   pointcut callPointCut() : call(
      void MyClass.foo(int, String));

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before() : callPointCut() && !within(PerThis +)
   {

      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice attached to the call point cut");
      System.out.println("Target: " + thisJoinPoint.getTarget());
      System.out.println("This: " + thisJoinPoint.getThis());
      System.out.println(
         "Aspect Instance: "
            + PerThis.aspectOf(thisJoinPoint.getThis()));
      System.out.println(
         "------------------------------------------------------------");

   }
}
