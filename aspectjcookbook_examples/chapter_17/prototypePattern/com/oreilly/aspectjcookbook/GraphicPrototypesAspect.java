package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.oopatterns.PrototypePattern;

public aspect GraphicPrototypesAspect extends PrototypePattern 
{
	declare parents : Graphic implements Prototype;

	declare parents : MusicalNote implements Prototype;

	declare parents : Staff implements Prototype;

	protected Object createCloneFor(Prototype object)
	{
		if (object instanceof MusicalNote)
		{
			return new MusicalNote(
				((MusicalNote) object).getX(),
				((MusicalNote) object).getY());
		}
		else if (object instanceof Staff)
		{
			return new Staff(((Staff) object).getX(), ((Staff) object).getY());
		}
		else
		{
			return null;
		}
	}
}