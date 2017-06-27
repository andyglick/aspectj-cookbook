package com.oreilly.aspectjcookbook.oopatterns;

import org.aspectj.lang.JoinPoint;

public abstract aspect DelegatingProxyPattern
   extends ProxyPattern 
{
   protected boolean reject(
      Object caller,
      Subject subject,
      JoinPoint joinPoint)
   {
      return false;
   }

   protected boolean delegate(
      Object caller,
      Subject subject,
      JoinPoint joinPoint)
   {
      return true;
   }

   protected Object rejectRequest(
      Object caller,
      Subject subject,
      JoinPoint joinPoint)
   {
      return null;
   }
}
