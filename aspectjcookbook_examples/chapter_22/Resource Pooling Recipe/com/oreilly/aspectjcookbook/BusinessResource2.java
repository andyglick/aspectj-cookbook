package com.oreilly.aspectjcookbook;

public class BusinessResource2
{
   public BusinessResource2()
   {
      System.out.println("Creating resource " + this);
   }
   
   public void bar()
   {
      System.out.println("Using the resource " + this + ", calling bar()");
   }
   
   public void finished()
   {
      System.out.println("Finished using the resource, called finished()");
   }
}
