package com.oreilly.aspectjcookbook;

public abstract aspect ProjectPolicyAspect 
{
   protected abstract pointcut allowedSystemOuts();
  
    declare warning : 
       call(* *.println(..)) && 
       !allowedSystemOuts() && 
       !BorderControllerAspect.withinTestingRegion()
    : "System.out usage detected. Suggest using logging?";
}
