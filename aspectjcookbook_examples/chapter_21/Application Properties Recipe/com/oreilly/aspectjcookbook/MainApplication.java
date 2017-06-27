package com.oreilly.aspectjcookbook;

public class MainApplication
{
   private static int property;
   
   public static void main(String[] args)
   {
      property++;
      System.out.println("Value of property = " + property);
      MyClass myObject = new MyClass();
      System.out.println(myObject);
      myObject.foo();
      System.out.println(myObject);
   }
}
