package com.oreilly.aspectjcookbook.oopatterns;

public abstract aspect PrototypePattern 
{

	protected interface Prototype
	{
	}

	public Object Prototype.clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	public Object cloneObject(Prototype object)
	{
		try
		{
			return object.clone();
		} 
		catch (CloneNotSupportedException ex)
		{
			return createCloneFor(object);
		}
	}

	protected Object createCloneFor(Prototype object)
	{
		return null;
	}
}