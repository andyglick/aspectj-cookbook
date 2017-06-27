package com.oreilly.aspectjcookbook.resourcepooling;

import java.util.List;
import java.util.ArrayList;

import com.oreilly.aspectjcookbook.BusinessResource;

public aspect BusinessResourcePoolingAspect extends ResourcePoolingAspect
{
   declare parents : BusinessResource implements Resource;

   public pointcut catchResourceConstruction() : call(public BusinessResource.new());
   
   public pointcut catchResourceDestruction(Resource resource) : 
      call(public void BusinessResource.close()) && target(resource);

   private class BusinessResourcePool implements ResourcePool
   {
      private static final int RESOURCE_POOL_SIZE = 10;
      
      List resources = new ArrayList();
      
      public BusinessResourcePool()
      {
         for (int x = 0; x < RESOURCE_POOL_SIZE; x++)
         {
            this.add(new BusinessResource());
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
            resources.add(new BusinessResource());
         }
         return (Resource) resources.remove(resources.size() - 1);
      }
   }
   
   protected void initializeSpecificPool()
   {
      try
      {
         this.resourcePools.putResourcePool(new BusinessResourcePool(), 
               Class.forName("com.oreilly.aspectjcookbook.BusinessResource"));
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
