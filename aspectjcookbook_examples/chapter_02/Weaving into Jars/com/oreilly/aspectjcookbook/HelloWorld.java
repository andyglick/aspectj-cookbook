package com.oreilly.aspectjcookbook;

/**
 * <p>Title: HelloWorld aspect for Recipe 2.2</p>
 * <p>Description: Simple aspect for demonstrating a very simple aspect</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect HelloWorld 
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
      call(void com.oreilly.aspectjcookbook.MyClass.foo(int, String));

   // Advice declaration
   before() : callPointCut()
   {

      System.out.println(
         "Hello World");
      System.out.println(
         "In the advice attached to the call point cut");
   }
}
