package com.oreilly.aspectjcookbook.oopatterns;

import java.util.WeakHashMap;

public abstract aspect ChainOfResponsibilityPattern 
{
   protected interface Handler
   {
   }
   
   private WeakHashMap successors = new WeakHashMap();
   
   protected void receiveRequest(Handler handler, Object request)
   {
      if (handler.acceptRequest(request))
      {
         handler.handleRequest(request);
      } else
      {
         // The handler will not accept the request
         Handler successor = getSuccessor(handler);
         if (successor == null)
         {
            // Last handler in the chain so must deal with the request
            // This is a rudimentary implementation and more complex
            // logic could be applied here or perhaps in the concrete
            // aspects that extend this abstract one
            handler.handleRequest(request);
         } else
         {
            // Hand the request on to the next successor in the chain
            receiveRequest(successor, request);
         }
      }
   }
   
   public boolean Handler.acceptRequest(Object request)
   {
      // The default as defined here is to reject the request
      // This is implemented by the application specific
      // concrete aspects
      return false;
   }
   
   public void Handler.handleRequest(Object request)
   {
      // A default empty implementation that is overridden
      // if required by the application specific concrete aspects
   }
   
   protected abstract pointcut eventTrigger(Handler handler, Object request);
   
   after(Handler handler, Object request) : eventTrigger(handler, request)
   {
      receiveRequest(handler, request);
   }
   
   public void setSuccessor(Handler handler, Handler successor)
   {
      successors.put(handler, successor);
   }
   
   public Handler getSuccessor(Handler handler)
   {
      return ((Handler) successors.get(handler));
   }
}