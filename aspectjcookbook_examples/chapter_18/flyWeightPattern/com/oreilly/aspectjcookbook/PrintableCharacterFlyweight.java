package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.FlyweightPattern;

public aspect PrintableCharacterFlyweight extends FlyweightPattern 
{
   declare parents : PrintableCharacter implements Flyweight;

   protected pointcut flyweightCreation(Object key) : call(public com.oreilly.aspectjcookbook.PrintableCharacter.new(Character)) && args(key);
   
   protected Flyweight createNewFlyweight(Object key)
   {
      return new PrintableCharacter((Character) key);
   }
}
