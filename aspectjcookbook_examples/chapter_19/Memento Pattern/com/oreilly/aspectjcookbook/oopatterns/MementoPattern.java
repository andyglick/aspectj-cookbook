package com.oreilly.aspectjcookbook.oopatterns;

public abstract aspect MementoPattern 
{
   public interface Memento
   {
      public void setState(Originator originator);
      public Object getState();
   }
   
   public interface Originator
   {
      public void setMemento(Memento memento);
      public Memento createMemento();
      public Object getState();
   }
}
