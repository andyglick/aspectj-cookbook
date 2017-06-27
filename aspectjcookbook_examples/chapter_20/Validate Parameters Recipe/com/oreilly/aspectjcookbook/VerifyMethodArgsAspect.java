package com.oreilly.aspectjcookbook;

import java.net.URL;
import java.net.MalformedURLException;

public aspect VerifyMethodArgsAspect
{
   private static final String COMMAND_LINE_USAGE = "MyAppliction usage :\n\n" +
   "\tjava MainApplication <url>";
   
   public pointcut captureMain(String[] arguments) : 
      execution(void MainApplication.main(String[])) && args(arguments);

   public pointcut createURLCalledinMainMethod() : call(java.net.URL.new(..)) && withincode(public void MainApplication.main(String[]));
   
   void around(String[] arguments) : captureMain(arguments)
   {
      if (arguments.length == 1)
      {
      	// Test that the host and port are valid
         try
         {
            URL url = new URL(arguments[0]);
            proceed(arguments);
         }
         catch(MalformedURLException mfe)
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
   
   // If necessary soften the exception that would normally have been raised
   // if the url parameter was badly formed, but only in the validated main method
   declare soft : MalformedURLException : createURLCalledinMainMethod();

}
