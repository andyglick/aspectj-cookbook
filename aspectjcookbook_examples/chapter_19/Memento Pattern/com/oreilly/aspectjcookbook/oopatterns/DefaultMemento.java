package com.oreilly.aspectjcookbook.oopatterns;

import com.oreilly.aspectjcookbook.oopatterns.MementoPattern.Memento;
import com.oreilly.aspectjcookbook.oopatterns.MementoPattern.Originator;

public class DefaultMemento implements Memento
{
	private Object state;

	public void setState(Originator originator)
	{
		this.state = originator.getState();
	}

	public Object getState()
	{
		return state;
	}
}
