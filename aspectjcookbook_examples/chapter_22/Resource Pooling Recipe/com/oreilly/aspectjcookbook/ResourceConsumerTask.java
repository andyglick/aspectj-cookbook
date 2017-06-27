package com.oreilly.aspectjcookbook;

import java.util.TimerTask;

public class ResourceConsumerTask extends TimerTask
{
   public void run()
   {
      for (int x = 0; x < 10; x++)
      {
         BusinessResource resource = new BusinessResource();
         resource.foo();
         resource.close();
         try
         {
            Thread.sleep(100);
         }
         catch (Exception e)
         {
         }
         
      }
   }
}
