package com.oreilly.aspectjcookbook.oopatterns;

public abstract aspect VisitorPattern 
{
   public interface Element
   {
      public void accept(Visitor visitor);
   }
   
   public interface CompositeElement extends Element
   {
      public Element[] getElements();
   }
   
   public interface Result
   {
   }
   
   public interface Visitor
   {
      public void visitElement(Element element);
      
      public void visitComposite(CompositeElement element);
      
      public Result getResult();
   }
   
   public void CompositeElement.accept(Visitor visitor)
   {
      visitor.visitComposite(this);
   }
   
   public void Element.accept(Visitor visitor)
   {
      visitor.visitElement(this);
   }
}