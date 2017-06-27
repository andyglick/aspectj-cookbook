package com.oreilly.aspectjcookbook.lazyloading;

public class LazyLoadingException extends Exception
{
   Exception originalException;
   
   public LazyLoadingException(String message)
   {
      super(message);
   }
   
   public LazyLoadingException(String message, Exception originalException)
   {
      super(message);
      this.originalException = originalException;
   }
   
   public Exception getOriginalException()
   {
      return this.originalException;
   }
}
