package com.oreilly.aspectjcookbook;

import java.util.LinkedList;

public class EmployeeCollection implements SimpleCollection
{
  LinkedList list = new LinkedList();

  public int count()
  {
    return list.size();
  }

  public boolean append(Object o)
  {
    list.addLast(o);
    return true;
  }

  public boolean remove(Object o)
  {
    return list.remove(o);
  }

  public Object get(int index)
  {
    return list.get(index);
  }
}
