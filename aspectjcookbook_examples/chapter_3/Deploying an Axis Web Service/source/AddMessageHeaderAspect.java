package com.oreilly.aspectjcookbook;

public aspect AddMessageHeaderAspect 
{
   public pointcut captureEcho(String message) : 
      execution(public String MyWebService.echo(String)) && 
      args(message);
   
   Object around(String message) : captureEcho(message)
   {
      return "Your original message was: " + message;
   }
}
