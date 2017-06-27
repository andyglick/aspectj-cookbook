package com.oreilly.aspectjcookbook.resourcepooling;

import java.util.WeakHashMap;

public abstract aspect ResourcePoolingAspect 
{  
   public interface Resource
   {
      
   }
   
   public interface ResourcePool
   {
      public void add(Resource resource);
      public Resource remove();
   }
   
   protected class ResourcePoolsCollection
   {
      WeakHashMap pools = new WeakHashMap();
      
      public void putResourcePool(ResourcePool pool, Class resourceClass)
      {
         pools.put(resourceClass, pool);
      }
      
      public ResourcePool getResourcePool(Class resourceClass)
      {
         return (ResourcePool) pools.get(resourceClass);
      }
   }
   
   protected ResourcePoolsCollection resourcePools = new ResourcePoolsCollection();
   
   public ResourcePoolingAspect()
   {  
      initializeSpecificPool();
   }
   
   protected abstract void initializeSpecificPool();
   
   private pointcut excludeAspects() : !within(ResourcePoolingAspect+);
   
   public abstract pointcut catchResourceConstruction();
   
   public abstract pointcut catchResourceDestruction(Resource resource);
   
   Object around() : catchResourceConstruction() && excludeAspects()
   {
      ResourcePool resources = 
         resourcePools.getResourcePool(thisJoinPoint.getSignature().getDeclaringType());
      return resources.remove();
   }
   
   Object around(Resource resource) : catchResourceDestruction(resource) && excludeAspects()
   {
      ResourcePool resources = 
         resourcePools.getResourcePool(thisJoinPoint.getSignature().getDeclaringType());
      Object returnValue = resourceReturnedToPool(resource);
      System.out.println("Resource added back into pool: " + resource);
      resources.add(resource);
      return returnValue;
   }
   
   protected abstract Object resourceReturnedToPool(Resource resource);
   
}
