package com.oreilly.aspectjcookbook.oopatterns;

import java.util.Hashtable;

public abstract aspect FlyweightPattern 
{
   private Hashtable flyweightPool = new Hashtable();

   public interface Flyweight
   {
   }; 
   
   protected abstract pointcut flyweightCreation(Object key);
   
   Object around(Object key) : flyweightCreation(key) && !within(com.oreilly.aspectjcookbook.oopatterns.FlyweightPattern+)
   {
      return this.checkFlyweight(key);
   }
   
   /**
    * Applies the flyweight checking policy.
    * 
    * @param key
    *           The key that determines whether a new flyweight should be
    *           created or not
    * @return The new object that could be a flyweight or a new instance.
    */
   public synchronized Flyweight checkFlyweight(Object key)
   {
      if (flyweightPool.containsKey(key))
      {
        return (Flyweight) flyweightPool.get(key);
      }
      else
      {
        Flyweight flyweight = createNewFlyweight(key);
        flyweightPool.put(key, flyweight);
        return flyweight;
      }
   }
   
   protected abstract Flyweight createNewFlyweight(Object key);
}