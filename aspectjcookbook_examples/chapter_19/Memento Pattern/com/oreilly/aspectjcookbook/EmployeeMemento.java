package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.MementoPattern;
import com.oreilly.aspectjcookbook.oopatterns.DefaultMemento;
import com.oreilly.aspectjcookbook.oopatterns.MementoException;

public aspect EmployeeMemento extends MementoPattern 
{
   declare parents : Employee implements Originator;

   public void Employee.setMemento(Memento memento)
   {
      Object object = memento.getState();
      Employee stateToRestore = (Employee) object;
      this.setName(stateToRestore.getName());
      this.setSalary(stateToRestore.getSalary());
   }

   public Memento Employee.createMemento()
   {
      Memento memento = new DefaultMemento();
      memento.setState(this);
      return memento;
   }

   public Object Employee.getState() throws MementoException
   {
      Employee employee = new Employee(this.getName(), this.getSalary());
      return employee;
   }
}

