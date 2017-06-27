package com.oreilly.aspectjcookbook;

public class ConcreteClassB
{
	private String name;

	private float wage;

	public ConcreteClassB(String name, float wage)
	{
		this.name = name;
		this.wage = wage;
	}

	public String getName()
	{
		return name;
	}

	public float getWage()
	{
		return wage;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setWage(float wage)
	{
		this.wage = wage;
	}
}
