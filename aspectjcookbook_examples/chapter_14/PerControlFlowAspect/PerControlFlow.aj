
/**
 * <p>Title: PreControlFlow aspect for Recipe 11.4</p>
 * <p>Description: Simple aspect for demonstrating that an aspect can be delared for instantiation per control flow, as designated by a specific pointcut.</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect PerControlFlow percflow(callPointCut())
{
   /*
   Specifies calling advice whenever a method
   matching the following rules gets called:
   
   Class Name: MyClass
   Method Name: foo
   Method Return Type: * (any return type)
   Method Parameters: an int followed by a String
   */
   pointcut callPointCut() : 
      call(void MyClass.foo(int, String));

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before() : callPointCut() && !within(PerControlFlow +)
   {

      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice attached to the call point cut");
      System.out.println("Target: " + thisJoinPoint.getTarget());
      System.out.println("This: " + thisJoinPoint.getThis());
      System.out.println(
         "Aspect Instance: " + PerControlFlow.aspectOf());
      System.out.println(
         "------------------------------------------------------------");
   }
}
