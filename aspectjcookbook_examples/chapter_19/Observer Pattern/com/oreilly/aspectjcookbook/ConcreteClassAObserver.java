package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.ObserverPattern;

public aspect ConcreteClassAObserver extends ObserverPattern 
{
   declare parents : ConcreteClassB implements Subject;

   declare parents : ConcreteClassA implements Observer;

   protected pointcut subjectChange(Subject s) : call(
      * ConcreteClassB.set*(..))
      && target(s);

   public void ConcreteClassA.notifyOfChange(Subject subject)
   {
      this.doSomething(
         "ConcreteClassA was notified of a change on " + subject);
   }
}
