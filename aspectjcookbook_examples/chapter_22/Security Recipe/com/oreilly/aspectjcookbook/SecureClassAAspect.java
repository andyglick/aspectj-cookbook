package com.oreilly.aspectjcookbook;


public aspect SecureClassAAspect 
{
   private boolean authenticated;
   
   public pointcut secureClassAMethods() : 
      call(* com.oreilly.aspectjcookbook.ClassA.*(..));
      
   Object around() : secureClassAMethods()
   {
      if (authenticated)
      {
         return proceed();
      }
      else
      {
         LoginScreen loginScreen = new LoginScreen();
         loginScreen.setVisible(true);
         
         // Use the authentication procedure of your choice here
         // In this simple example we are just going to check that 
         // it is the one person we know of
         if ((loginScreen.getUsername().equals("Richard")) && 
               (new String(loginScreen.getPassword()).equals("password")))
         {
            authenticated = true;
            loginScreen.dispose();
            return proceed();
         }
         loginScreen.dispose();
         return null;
      }
   }
}
