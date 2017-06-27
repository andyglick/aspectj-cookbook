package com.oreilly.aspectjcookbook.transactions;

import com.oreilly.aspectjcookbook.Account;
import com.oreilly.aspectjcookbook.InsufficientFundsException;

public aspect TransferTransactionAspect extends TransactionAspect 
{
   protected pointcut transactionalCall() : 
      call(public void com.oreilly.aspectjcookbook.Bank.transfer(..));
   
   private class TransferTransaction extends ThreadLocal implements Transaction
   {
      private Account from;
      private Account to;
      private float value;
      
      public TransferTransaction(Account from, Account to, float value)
      {
         this.from = from;
         this.to = to;
         this.value = value;
      }
      
      public void commit()
      {
         System.out.println("Committing");
         // Nothing to actually commit here, all the changes have been accepted ok
      }
      
      public void rollback()
      {
         System.out.println("Rolling back");
         try
         {
            to.debit(value);
         }
         catch(InsufficientFundsException ife)
         {
            System.err.println("Could not complete rollback!");
            ife.printStackTrace();
         }
      }
   }
   
   protected void setupTransaction(Object[] args)
   {
      this.transaction = 
         new TransferTransaction(
               (Account) args[0], 
               (Account) args[1], 
               ((Float)args[2]).floatValue());
   }
}
