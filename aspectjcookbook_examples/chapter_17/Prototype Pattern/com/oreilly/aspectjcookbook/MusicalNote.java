package com.oreilly.aspectjcookbook;

public class MusicalNote extends Graphic
{
	public MusicalNote(int x, int y)
	{
		super(x, y);
	}

	public void draw()
	{
		System.out.println("This is a musical note with x,y positions of:");
		System.out.println("x:" + this.x);
		System.out.println("y:" + this.y);
	}
}
