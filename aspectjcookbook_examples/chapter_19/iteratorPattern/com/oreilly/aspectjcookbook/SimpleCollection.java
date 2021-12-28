package com.oreilly.aspectjcookbook;

public interface SimpleCollection
{
	public int count();

	public boolean append(Object o);

	public boolean remove(Object o);

	public Object get(int index);
}
