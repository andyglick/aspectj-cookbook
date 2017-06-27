package com.oreilly.aspectjcookbook;

import java.net.URL;

public class MainApplication
{

   public static void main(String[] args)
   {
      // Assuming that the first argument supplied is a url
      // Concentrating on the business logic, not validation which
      // is handled by the aspect.
      URL url = new URL(args[0]);
      
      System.out.println("Application Started, doing stuff with " + url);
   }
}