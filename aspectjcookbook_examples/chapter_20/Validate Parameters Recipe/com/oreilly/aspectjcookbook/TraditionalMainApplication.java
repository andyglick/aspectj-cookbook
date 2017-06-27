package com.oreilly.aspectjcookbook;

import java.net.URL;
import java.net.MalformedURLException;

public class TraditionalMainApplication
{
   private static final String COMMAND_LINE_USAGE = "MyAppliction usage :\n\n"
         + "\tjava MainApplication <url>";

   public static void main(String[] args)
   {
      if (args.length == 1)
      {
         try
         {
            // Assuming that the first argument supplied is a url
            // Concentrating on the business logic, not validation which
            // is handled by the aspect.
            URL url = new URL(args[0]);

            System.out.println("Application Started, doing stuff with " + url);
         }
         catch (MalformedURLException mue)
         {
            System.err.println(COMMAND_LINE_USAGE);
            System.err.println("Please enter a valid URL for <url>");
         }
      }
      else
      {
         System.err.println(COMMAND_LINE_USAGE);
      }
   }
}