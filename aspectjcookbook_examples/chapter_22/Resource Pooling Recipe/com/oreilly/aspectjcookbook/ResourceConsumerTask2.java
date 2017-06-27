package com.oreilly.aspectjcookbook;

import java.util.TimerTask;

public class ResourceConsumerTask2 extends TimerTask
{
   public void run()
   {
      for (int x = 0; x < 10; x++)
      {
         BusinessResource2 resource = new BusinessResource2();
         resource.bar();
         resource.finished();
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
