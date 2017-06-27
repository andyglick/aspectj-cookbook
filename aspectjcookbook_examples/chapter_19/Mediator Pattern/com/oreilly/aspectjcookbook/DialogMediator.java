package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.MediatorPattern;

public aspect DialogMediator extends MediatorPattern 
{
   declare parents : ListBox implements Colleague;
   declare parents : EntryField implements Mediator;
   
   protected pointcut change(Colleague c) : (
         execution(void ListBox.setSelection(..)) && this(c));
   
   protected void notifyMediator(Colleague c, Mediator m)
   {
      ListBox listBox = (ListBox) c;
      EntryField entryField = (EntryField) m;
      entryField.setText(listBox.getSelection());
   }
}
