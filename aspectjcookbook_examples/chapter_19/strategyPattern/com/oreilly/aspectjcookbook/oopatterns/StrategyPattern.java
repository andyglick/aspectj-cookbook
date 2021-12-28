package com.oreilly.aspectjcookbook.oopatterns;

import java.util.Hashtable;

public abstract aspect StrategyPattern 
{
   Hashtable strategyPerContext = new Hashtable();
   
   protected interface Strategy
   {
   }
   
   protected interface Context
   {
   }
   
   public void setConcreteStrategy(Context c, Strategy s)
   {
      strategyPerContext.put(c, s);
   }
   
   public Strategy getConcreteStrategy(Context c)
   {
      return (Strategy) strategyPerContext.get(c);
   }
}
