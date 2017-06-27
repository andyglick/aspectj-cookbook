package com.oreilly.aspectjcookbook;

import java.util.Iterator;

public class EmployeeIterator implements Iterator
{
   protected int currentIndex;
   protected boolean forward;
   protected SimpleCollection simpleCollection;
   
   public EmployeeIterator(SimpleCollection simpleCollection, boolean forward)
   {
      super();
      this.forward = forward;
      this.simpleCollection = simpleCollection;
      if (this.forward)
      {
         currentIndex = 0;
      }
      else
      {
         currentIndex = simpleCollection.count();
      }
   }
   
   public boolean hasNext()
   {
      if (this.forward)
      {
         return (currentIndex < this.simpleCollection.count());
      }
      else
      {
         return (currentIndex > 0);
      }
      
   }
   
   public void remove()
   {
      throw new UnsupportedOperationException("remove() not supported");
   }
   
   public Object next()
   {
      if (!hasNext())
      {
         throw new ArrayIndexOutOfBoundsException("Iterator out of Bounds");
      }
      else
      {
         if (this.forward)
         {
            return simpleCollection.get(currentIndex++);
         }
         else
         {
            return simpleCollection.get(--currentIndex);
         }
      }
   }
}
