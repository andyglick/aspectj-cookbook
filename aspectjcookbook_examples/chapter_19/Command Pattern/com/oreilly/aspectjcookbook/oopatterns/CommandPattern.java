package com.oreilly.aspectjcookbook.oopatterns;

import java.util.WeakHashMap;

public abstract aspect CommandPattern 
{
   // Define the Command Pattern interfaces
   
   // This interface will be fulfilled by all Commands
   public interface Command
   {
      
      public void executeCommand(CommandReceiver receiver);
      
      public boolean isExecutable();
   }
   
   //	This interface will be fulfilled by all CommandInvokers
   public interface CommandInvoker
   {
   }
   
   //	This interface will be fulfilled by all CommandReceivers
   public interface CommandReceiver
   {
   }
   
   private WeakHashMap mappingInvokerToCommand = new WeakHashMap();
   
   public Object setCommand(CommandInvoker invoker, Command command)
   {
      return mappingInvokerToCommand.put(invoker, command);
   }
   
   public Object removeCommand(CommandInvoker invoker)
   {
      return setCommand(invoker, null);
   }
   
   public Command getCommand(CommandInvoker invoker)
   {
      return (Command) mappingInvokerToCommand.get(invoker);
   }
   
   private WeakHashMap mappingCommandToReceiver = new WeakHashMap();
   
   public Object setReceiver(Command command, CommandReceiver receiver)
   {
      return mappingCommandToReceiver.put(command, receiver);
   }
   
   public CommandReceiver getReceiver(Command command)
   {
      return (CommandReceiver) mappingCommandToReceiver.get(command);
   }
   
   protected abstract pointcut commandTrigger(CommandInvoker invoker);
   
   after(CommandInvoker invoker) : commandTrigger(invoker)
   {
      Command command = getCommand(invoker);
      if (command != null)
      {
         CommandReceiver receiver = getReceiver(command);
         command.executeCommand(receiver);
      } else
      {
         // Do nothing: This Invoker has no associated command
      }
   }
   
   protected pointcut setCommandTrigger(CommandInvoker invoker, Command command);
   
   after(CommandInvoker invoker, Command command) : setCommandTrigger(invoker, command)
   {
      if (invoker != null)
         setCommand(invoker, command);
   }
   
   protected pointcut removeCommandTrigger(CommandInvoker invoker);
   
   after(CommandInvoker invoker) : removeCommandTrigger(invoker)
   {
      if (invoker != null)
         removeCommand(invoker);
   }
   
   public boolean Command.isExecutable()
   {
      return true;
   }
}
