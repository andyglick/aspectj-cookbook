package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.tracing.TracingAspect;

public aspect ApplicationSpecificTracingAspect extends TracingAspect
{
   public pointcut pointsToBeTraced() : call(* *.*(..));
   
   public pointcut pointsToBeExcluded() : call(void java.io.PrintStream.*(..));
}
