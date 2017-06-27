package com.oreilly.aspectjcookbook.logging;

import org.aspectj.lang.JoinPoint;
import com.oreilly.aspectjcookbook.tracing.TracingAspect;

public aspect PackageSpecificLoggingAspect extends LoggingAspect
{
   // Ensures that the System level logging is applied first, then the more specific package level
   // Reference previous chapters recipes
   declare precedence : ApplicationLoggingAspect, PackageSpecificLoggingAspect;
   
   // Selects calls to all methods in the application
   public pointcut pointsToBeTraced() : call(* com.oreilly.aspectjcookbook.PackageA.*.*(..));
   
   // Protects against calls to System.out
   public pointcut pointsToBeExcluded() : call(void java.io.PrintStream.*(..));
   
   // Selects calls to all methods in the application
   public pointcut exceptionsToBeLogged() : handler(PackageA.*);
   
   protected void traceBefore(JoinPoint joinPoint, Object object)
   {
      System.out.println("<before>" + joinPoint.getSignature() + "</before>");
   }
   
   protected void traceStaticBefore(JoinPoint joinPoint)
   {
      System.out.println("<before type=\"static\">" + joinPoint.getSignature() + "</before>");
   }
   
   protected void traceAfter(JoinPoint joinPoint, Object object)
   {
      System.out.println("<after>" + joinPoint.getSignature() + "</after>");
   }
   
   protected void traceStaticAfter(JoinPoint joinPoint)
   {
      System.out.println("<after type=\"static\">" + joinPoint.getSignature() + "</after>");
   }
   
   protected void logException(JoinPoint joinPoint)
   {
      System.out.println("<exception>" + joinPoint.getSignature() + "</exception>");
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
         within(PackageSpecificLoggingAspect) &&
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
