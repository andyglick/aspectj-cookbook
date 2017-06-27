package com.oreilly.aspectjcookbook;

public class Bank
{
   public void transfer(Account from, Account to, float amount) throws InsufficientFundsException
   {
      to.credit(amount);
      from.debit(amount);
   }
}
