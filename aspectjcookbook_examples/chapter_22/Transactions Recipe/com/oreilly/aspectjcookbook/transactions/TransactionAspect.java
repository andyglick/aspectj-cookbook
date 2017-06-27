package com.oreilly.aspectjcookbook.transactions;

public abstract aspect TransactionAspect 
{
   protected abstract pointcut transactionalCall();
   
   protected interface Transaction
   {
      public void commit();
      public void rollback();
   }
   
   protected pointcut transactionBoundary() : 
      transactionalCall() && !cflowbelow(transactionalCall());
   
   before() : transactionBoundary() 
   { 
      setupTransaction(thisJoinPoint.getArgs());
   }
   
   after() returning: transactionBoundary() 
   { 
      transaction.commit();
   }
   
   after() throwing: transactionBoundary() 
   { 
      transaction.rollback();  
   }
   
   protected abstract void setupTransaction(Object[] args);
   
   protected Transaction transaction;
}
