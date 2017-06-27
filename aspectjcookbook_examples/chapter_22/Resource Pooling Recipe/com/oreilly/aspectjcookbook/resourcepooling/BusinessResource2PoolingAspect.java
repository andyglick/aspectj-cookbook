package com.oreilly.aspectjcookbook.resourcepooling;

import java.util.List;
import java.util.ArrayList;

import com.oreilly.aspectjcookbook.BusinessResource2;

public aspect BusinessResource2PoolingAspect extends ResourcePoolingAspect
{
   declare parents : BusinessResource2 implements Resource;

   public pointcut catchResourceConstruction() : call(public BusinessResource2.new());

   public pointcut catchResourceDestruction(Resource resource) : 
      call(public void BusinessResource2.finished()) && target(resource);

   private class BusinessResource2Pool implements ResourcePool
   {
      private static final int RESOURCE_POOL_SIZE = 10;
      
      List resources = new ArrayList();
      
      public BusinessResource2Pool()
      {
         for (int x = 0; x < RESOURCE_POOL_SIZE; x++)
         {
            this.add(new BusinessResource2());
         }
      }
      
      public synchronized void add(Resource resource)
      {
         resources.add(resource);
      }
      
      public synchronized Resource remove()
      {
         if (resources.size() == 0)
         {
            resources.add(new BusinessResource2());
         }
         return (Resource) resources.remove(resources.size() - 1);
      }
   }

   protected void initializeSpecificPool()
   {
      try
      {
         this.resourcePools.putResourcePool(new BusinessResource2Pool(), 
               Class.forName("com.oreilly.aspectjcookbook.BusinessResource2"));
      }
      catch (ClassNotFoundException cnfe)
      {
         System.err.println("Couldn't find resource class to pool");
      }
         
   }

   protected Object resourceReturnedToPool(Resource resource)
   {
      // Do any resource specific tudying up if necessary
      // None to do in this example
      return null;
   }
}
