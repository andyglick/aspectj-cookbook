package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.IteratorPattern;
import java.util.Iterator;

public aspect EmployeeIteration extends IteratorPattern 
{
   declare parents : EmployeeCollection implements Aggregate;

   public Iterator EmployeeCollection.createIterator()
   {
      return new EmployeeIterator(this, true);
   }

   public Iterator EmployeeCollection.createReverseIterator()
   {
      return new EmployeeIterator(this, false);
   }
}
