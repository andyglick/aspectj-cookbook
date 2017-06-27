package com.oreilly.aspectjcookbook.lazyloading;

import com.oreilly.aspectjcookbook.oopatterns.DelegatingProxyPattern;

public abstract aspect LazyLoading extends DelegatingProxyPattern
{
   public interface RealComponent extends Subject
   {
   }
   
   public interface LazyProxy extends RealComponent
   {
      public RealComponent getRealComponent() throws LazyLoadingException;
   }
   
   public abstract LazyProxy initializeComponent(Object configuration);
}
