package com.oreilly.aspectjcookbook.oopatterns;

import java.util.Iterator;

public abstract aspect IteratorPattern 
{
   public interface Aggregate
   {
      public Iterator createIterator();
      
      public Iterator createReverseIterator();
   }
}
