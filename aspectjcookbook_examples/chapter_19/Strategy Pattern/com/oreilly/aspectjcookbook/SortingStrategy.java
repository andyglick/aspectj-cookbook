package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.StrategyPattern;

public aspect SortingStrategy extends StrategyPattern 
{
   declare parents : Sorter implements Context;
   declare parents : LinearSorter implements Strategy;
   declare parents : BubbleSorter implements Strategy;
   
   int[] around(Sorter s, int[] numbers) : call(int[] Sorter.sort(int[]))
      && target(s)
      && args(numbers)
   {
      Strategy strategy = getConcreteStrategy(s);
      if (strategy instanceof BubbleSorter)
         ((BubbleSorter) strategy).sort(numbers);
      else if (strategy instanceof LinearSorter)
         ((LinearSorter) strategy).sort(numbers);
      return numbers;
   }
}
