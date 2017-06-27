package com.oreilly.aspectjcookbook;

import java.util.Iterator;

public class MainApplication
{
  public static void main(String[] args)
  {
    EmployeeCollection employeeCollection = new EmployeeCollection();

    employeeCollection.append(new Employee("Rob", 100000l));
    employeeCollection.append(new Employee("Laura", 101000l));
    employeeCollection.append(new Employee("Andy", 102000l));
    employeeCollection.append(new Employee("Kim", 103000l));
    employeeCollection.append(new Employee("Bobbie", 104000l));

    System.out.println("Employee Collection has been set up with 5 objects");

    System.out.println("Printing the collection out in order...");

    Iterator forwardIterator = employeeCollection.createIterator();
    while (forwardIterator.hasNext())
    {
      System.out.println(forwardIterator.next());
    }

    System.out.println("Printing the collection out in reverse order...");
    Iterator reverseIterator = employeeCollection.createReverseIterator();
    while (reverseIterator.hasNext())
    {
      System.out.println(reverseIterator.next());
    }
  }
}
