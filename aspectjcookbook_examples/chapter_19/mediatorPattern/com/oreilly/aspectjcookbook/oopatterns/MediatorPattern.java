package com.oreilly.aspectjcookbook.oopatterns;

import java.util.WeakHashMap;

public abstract aspect MediatorPattern 
{
   protected interface Colleague
   {
   }
   
   protected interface Mediator
   {
   }
   
   private WeakHashMap mappingColleagueToMediator = new WeakHashMap();
   
   private Mediator getMediator(Colleague colleague)
   {
      Mediator mediator =
         (Mediator) mappingColleagueToMediator.get(colleague);
      return mediator;
   }
   
   public void setMediator(Colleague c, Mediator m)
   {
      mappingColleagueToMediator.put(c, m);
   }
   
   protected abstract pointcut change(Colleague c);
   
   after(Colleague c) : change(c)
   {
      notifyMediator(c, getMediator(c));
   }
   
   protected abstract void notifyMediator(Colleague c, Mediator m);
}
