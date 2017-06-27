package com.oreilly.aspectjcookbook.oopatterns;

public abstract aspect DecoratorPattern 
{
   public interface DecoratedComponent
   {
   };
   
   private boolean DecoratedComponent.decorated = false;
   
   public void DecoratedComponent.setDecorated(boolean decorated)
   {
      this.decorated = decorated;
   }
   
   public boolean DecoratedComponent.isDecorated()
   {
      return this.decorated;
   }
}
