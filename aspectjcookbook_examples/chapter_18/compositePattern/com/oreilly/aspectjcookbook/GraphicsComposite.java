package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.CompositePattern;
import java.io.PrintStream;

public aspect GraphicsComposite extends CompositePattern 
{
   declare parents : Window implements Composite;
   
   declare parents : Line implements Leaf;
   
   declare parents : Rectangle implements Leaf;
   
   public void Component.draw(PrintStream s)
   {
      s.println("Drawing: " + this);
   }
   
   public void Composite.draw(final PrintStream s)
   {
      s.println("Composite: " + this);
      GraphicsComposite.aspectOf().recurseOperation(this, new Visitor()
         {
            public void doOperation(Component c)
            {
               c.draw(s);
            }
         });
   }
   
   public void Leaf.draw(PrintStream s)
   {
      s.println("Drawing Leaf: " + this);
   }
   
}
