
/**
 * <p>Title: MyAspect aspect for Recipe 2.4</p>
 * <p>Description: Simple aspect for demonstrating a very simple aspect being woven using a .lst file</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect MyAspect 
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
   before() : callPointCut() && !within(MyAspect +)
   {

      System.out.println(
         "MyAspect before() advice");
      System.out.println(
         "In the advice attached to the call point cut");
   }
}
