
/**
 * <p>Title: AspectB aspect for Recipe 10.9</p>
 * <p>Description: Simple aspect for demonstrating that aspect precedence can be controlled.</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect AspectB
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
   before() : callPointCut() && !within(AspectB +)
   {

      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice of AspectB");
      System.out.println("Target: " + thisJoinPoint.getTarget());
      System.out.println("This: " + thisJoinPoint.getThis());
      System.out.println(
         "Aspect Instance: " + AspectB.aspectOf());
      System.out.println(
         "------------------------------------------------------------");
   }
}
