package com.oreilly.aspectjcookbook.oopatterns;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public abstract aspect ObserverPattern 
{
   protected interface Subject
   {
      public void addObserver(Observer observer);
      public void removeObserver(Observer observer);
   }
   
   protected interface Observer
   {
      public void notifyOfChange(Subject subject);
   }
   
   private List Subject.observers = new LinkedList();
   
   public void Subject.addObserver(Observer observer)
   {
      this.observers.add(observer);
   }
   
   public void Subject.removeObserver(Observer observer)
   {
      this.observers.remove(observer);
   }
   
   private synchronized void Subject.notifyObservers()
   {
      Iterator iter = this.observers.iterator();
      while (iter.hasNext())
      {
         ((Observer)iter.next()).notifyOfChange(this);
      }
   }
   
   protected abstract pointcut subjectChange(Subject s);
   
   after(Subject subject) : subjectChange(subject)
   {
      subject.notifyObservers();
   }
}
