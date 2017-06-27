package com.oreilly.aspectjcookbook.myapp;

import com.oreilly.aspectjcookbook.ProjectPolicyAspect;
import com.oreilly.aspectjcookbook.BorderControllerAspect;

public aspect MyAppPolicyAspect extends ProjectPolicyAspect
{
   /**
    * Specifies regions within the application where system out 
    * messages are allowed.
    */
   protected pointcut allowedSystemOuts() : 
      BorderControllerAspect.withinMyAppMainMethod() || 
      BorderControllerAspect.withinThirdParty() || 
      BorderControllerAspect.withinTestingRegion();
}
