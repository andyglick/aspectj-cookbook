package com.oreilly.aspectjcookbook;

public aspect ControlClassSelectionAspect 
{
   public pointcut myClassConstructor() : call(MyClass.new());
   
   Object around() : myClassConstructor()
   {
      return new AnotherClass();
   }
   
   // Runtime selection variation
   /*
   Object around() : myClassConstructor() && 
                     if (System.getProperty("select_class").equals("AnotherClass"))
   {
      return new AnotherClass();
   }
   */
}
