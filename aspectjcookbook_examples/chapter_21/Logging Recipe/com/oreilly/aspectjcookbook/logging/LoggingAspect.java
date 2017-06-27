
package com.oreilly.aspectjcookbook.logging;

import com.oreilly.aspectjcookbook.tracing.TracingAspect;
import org.aspectj.lang.JoinPoint;

public abstract aspect LoggingAspect extends TracingAspect
{
  protected abstract pointcut exceptionsToBeLogged();

  private pointcut filteredExceptionCapture() : 
     exceptionsToBeLogged() && 
     !pointsToBeExcluded();

  before() : filteredExceptionCapture()
  {
     logException(thisJoinPoint);
  }
  
  protected abstract void logException(JoinPoint joinPoint);
}
