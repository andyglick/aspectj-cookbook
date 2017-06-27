package com.oreilly.aspectjcookbook;

public class Employee
{
	private String name;
	private long salary;

	public Employee(String name, long salary)
	{
		this.name = name;
		this.salary = salary;
	}

	public String toString()
	{
		return this.name + ":" + this.salary;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getSalary()
	{
		return salary;
	}

	public void setSalary(long salary)
	{
		this.salary = salary;
	}
}
