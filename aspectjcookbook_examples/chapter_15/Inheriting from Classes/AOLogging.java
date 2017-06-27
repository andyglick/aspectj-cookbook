
/**
 * <p>Title: AOLogging aspect for Recipe 12.3</p>
 * <p>Description: Simple aspect for demonstrating the ability to define and implement abstract aspects</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect AOLogging extends OOLogging 
{
   /*
   Specifies calling advice whenever a method
   matching the following rules gets called:
   
   Class Name: MyClass
   Method Name: foo
   Method Return Type: void
   Method Parameters: an int followed by a String
   */
   pointcut callPointcut() : call(void MyClass.foo(int, String));

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before() : callPointcut()
      && !within(AOLogging +)
      && !within(OOLogging)
   {
      this.logEntry(thisJoinPoint.toShortString());
   }
}
