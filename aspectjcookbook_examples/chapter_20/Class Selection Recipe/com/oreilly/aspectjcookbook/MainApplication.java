package com.oreilly.aspectjcookbook;

public class MainApplication
{

   /*
   public static void traditionalOOImplementationSelection()
   {
      MyInterface myObject = new MyClass(); // Specifies the MyClass implementation of the interface
      System.out.println(myObject);
      myObject.foo();
     
      MyInterface myObject = new MyClass(); // Specifies the AnotherClass implementation of the interface
      System.out.println(myObject);
      myObject.foo();
   }
   */
     
   public static void aspectImplementationSelection()
   {
      MyInterface myObject = new MyClass(); // Specifies the default implementation of the interface
      
      System.out.println(myObject);
      myObject.foo();
   }
   
   public static void main(String[] args)
   {
      //traditionalOOImplementationSelection();
      aspectImplementationSelection();
   }
}
