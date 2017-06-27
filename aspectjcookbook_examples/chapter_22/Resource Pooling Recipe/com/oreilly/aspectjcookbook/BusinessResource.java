package com.oreilly.aspectjcookbook;

public class BusinessResource
{
   public BusinessResource()
   {
      System.out.println("Creating resource " + this);
   }
   
   public void foo()
   {
      System.out.println("Using the resource " + this + ", calling foo()");
   }
   
   public void close()
   {
      System.out.println("Finished using the resource, called close()");
   }
}
