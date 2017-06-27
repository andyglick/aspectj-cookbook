package com.oreilly.aspectjcookbook.logging;

import org.aspectj.lang.JoinPoint;

import com.oreilly.aspectjcookbook.tracing.TracingAspect;

public aspect ApplicationLoggingAspect extends LoggingAspect
{
   public pointcut pointsToBeTraced() : call(* *.*(..));
   
   public pointcut pointsToBeExcluded() :  call(* java.io.*.*(..));
   
   public pointcut exceptionsToBeLogged() : handler(com.oreilly.aspectjcookbook.PackageA.BusinessException);
   
   protected void traceBefore(JoinPoint joinPoint, Object caller)
   {
      System.out.println("Log Message: Called " + joinPoint.getSignature());
   }
   
   protected void traceStaticBefore(JoinPoint joinPoint)
   {
      System.out.println("Log Message: Statically Called " + joinPoint.getSignature());
   }
   
   protected void traceAfter(JoinPoint joinPoint, Object object)
   {
      System.out.println("Log Message: Returned from " + joinPoint.getSignature());
   }
   
   protected void traceStaticAfter(JoinPoint joinPoint)
   {
      System.out.println("Log Message: Returned from static call to " + joinPoint.getSignature());
   }
   
   protected void logException(JoinPoint joinPoint)
   {
      System.out.println("Log Message: " + joinPoint.getArgs()[0] + " exception thrown");
   }
   
   private static aspect FormatCallDepthAspect
   {
      private static int callDepth;
      
      private pointcut captureTraceBefore() : call(protected void TracingAspect.trace*Before(..));
      
      private pointcut captureTraceAfter() : call(protected void TracingAspect.trace*After(..));
      
      after() : captureTraceBefore()
      {
         callDepth++;
      }
      
      before() : captureTraceAfter()
      {
         callDepth--;
      }
      
      private pointcut captureMessageOutput(String message) : 
         call(* *.println(String)) && 
         args(message) &&
         within(ApplicationLoggingAspect) &&
         !within(FormatCallDepthAspect);
      
      Object around(String originalMessage) : captureMessageOutput(originalMessage)
      {
         StringBuffer buffer = new StringBuffer();
         for (int x = 0; x < callDepth; x++)
         {
            buffer.append("  ");
         }
         buffer.append(originalMessage);
         
         return proceed(buffer.toString());
      }
   }
}
