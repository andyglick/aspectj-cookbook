package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.ChainOfResponsibilityPattern;

public aspect HelpChain extends ChainOfResponsibilityPattern 
{
   declare parents : PrintButton implements Handler;
   declare parents : PrintDialog implements Handler;
   declare parents : Manager implements Handler;
   
   protected pointcut eventTrigger(Handler handler, Object event) : call(
         void PrintButton.doClick(..))
         && target(handler)
         && args(event);
   
   // We introduce the attributes purely to give the handlers a means of
   // deciding if they have already handled a request or not
   // If they have then they are allowed to refuse the request in this
   // example.
   // In a real application these would not be required.
   private boolean Handler.alreadyHandledRequest = false;
   
   public boolean Handler.acceptRequest(Object event)
   {
      return !this.alreadyHandledRequest;
   }
   
   public void PrintButton.handleRequest(Object event)
   {
      if (!this.acceptRequest(event))
      {
         System.out.println(
         "PrintButton Forced to handle Request due to being last in the chain (Implementation Decision)");
      }
      System.out.println("PrintButton handling request: " + event);
      this.alreadyHandledRequest = true;
   }
   
   public void PrintDialog.handleRequest(Object event)
   {
      if (!this.acceptRequest(event))
      {
         System.out.println(
         "PrintDialog Forced to handle Request due to being last in the chain (Implementation Decision)");
      }
      System.out.println("PrintDialog handling request: " + event);
      this.alreadyHandledRequest = true;
   }
   
   public void Manager.handleRequest(Object event)
   {
      if (!this.acceptRequest(event))
      {
         System.out.println(
         "Manager Forced to handle Request due to being last in the chain (Implementation Decision)");
      }
      System.out.println("Manager handling request: " + event);
      
      this.alreadyHandledRequest = true;
   }
}
