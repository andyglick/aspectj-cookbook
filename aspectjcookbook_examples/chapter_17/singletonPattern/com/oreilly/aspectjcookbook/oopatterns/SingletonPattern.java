package com.oreilly.aspectjcookbook.oopatterns;

import java.util.Hashtable;

public abstract aspect SingletonPattern issingleton()
{
   protected Hashtable singletons = new Hashtable();

   public interface Singleton
   {
   }

   public interface NonSingleton
   {
   }

   // Pointcut to define specify an interest in all creations
   // of all Classes that extend Singleton
   pointcut selectSingletons() : call((Singleton +).new (..));

   // Pointcut to ensure that any classes in the Singleton inheritance tree
   // that are marked as Non Singletons are not included in the Singleton
   // logic.
   pointcut excludeNonSingletons() : !call((NonSingleton +).new (..));

   Object around() : selectSingletons() && excludeNonSingletons()
   {
      Class type = thisJoinPoint.getSignature().getDeclaringType();

      synchronized(singletons)
      {
         if (singletons.get(type) == null)
         {
            singletons.put(type, proceed());
         }
      }
      return (Object) singletons.get(type);
   }
}