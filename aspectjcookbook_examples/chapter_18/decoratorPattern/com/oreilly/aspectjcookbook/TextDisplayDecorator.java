package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.DecoratorPattern;

public aspect TextDisplayDecorator extends DecoratorPattern 
{
  declare parents : TextDisplay implements DecoratedComponent;

  public pointcut selectDecorators(Object object) : call(public void TextDisplay.display(String))
    && target(object);
  
  before(Object object) : selectDecorators(object) && if(((DecoratedComponent)object).isDecorated())
  {
     System.out.print("<Decoration>");
  }
  
  after(Object object) : selectDecorators(object) && if(((DecoratedComponent)object).isDecorated())
  {
     System.out.print("</Decoration>");
  }
}
