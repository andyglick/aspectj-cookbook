package com.oreilly.aspectjcookbook.features;

public class FeatureA implements Feature
{
   public void doSomething(String message)
   {
      System.out.println(
         "doSomething called in "
            + this
            + ", with: "
            + message);
   }
}
