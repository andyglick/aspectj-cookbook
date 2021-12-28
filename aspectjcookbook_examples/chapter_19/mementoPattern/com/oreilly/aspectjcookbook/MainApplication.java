package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.MementoPattern.Memento;

/**
 * Works as the 'Caretaker' role in the design pattern.
 * @author russellmiles
 *
 */
public class MainApplication
{
	public static void main(String[] args)
	{
		Memento memento = null;
		Employee employee = new Employee("Laura", 100000l);

		for (int stepCount = 1; stepCount <= 5; stepCount++)
		{
			employee.setSalary(employee.getSalary() + 5000);
			System.out.println("Step " + stepCount);
			System.out.println(employee);
			if (stepCount == 3)
			{
				try
				{
					memento = employee.createMemento();
				}
				catch (Exception e)
				{
					System.out.println("Could not store memento");
				}
			}
		}

		System.out.println("\nAttempting to reinstate state (Step 3)...\n");
		employee.setMemento(memento);
		System.out.println(employee);
	}
}
