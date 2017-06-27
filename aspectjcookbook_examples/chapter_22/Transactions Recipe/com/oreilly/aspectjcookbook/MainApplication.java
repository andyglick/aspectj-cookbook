package com.oreilly.aspectjcookbook;

public class MainApplication
{

   public static void main(String[] args)
   {
      // Setup the accounts
      Bank bank = new Bank();
      BankAccount accountA = new BankAccount(123456);
      BankAccount accountB = new BankAccount(567890);

      // One their own, a simple credit method cannot cause any problems
      accountA.credit(50.0f);

      // Print out the funds before we conduct some transfers on them
      System.out.println("The funds in account A total: £"
            + accountA.getBalance());
      System.out.println("The funds in account B total: £"
            + accountB.getBalance());

      // Catch any problems with the debits
      try
      {
         System.out.println("Performing first transaction");
         bank.transfer(accountA, accountB, 25);
         System.out.println("Performing second transaction");
         bank.transfer(accountA, accountB, 50);
      }
      catch (InsufficientFundsException ife)
      {
         // Too late to do much about it
         System.err.println("A problem occured whilst executing a transfer: \n"
               + "\t" + ife.getMessage());
      }

      // Print out the state of our accounts after the funds have been
      // transfered
      System.out.println("The funds for account A should total £25.00");
      System.out.println("The funds for account B should total £25.00");
      System.out.println("The funds in account A total: £"
            + accountA.getBalance());
      System.out.println("The funds in account B total: £"
            + accountB.getBalance());
   }
}