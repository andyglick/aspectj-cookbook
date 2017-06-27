package com.oreilly.aspectjcookbook;

public class Staff extends Graphic
{
	public Staff(int x, int y)
	{
		super(x, y);
	}

	public void draw()
	{
		System.out.println("This is a staff symbol with x,y positions of:");
		System.out.println("x:" + this.x);
		System.out.println("y:" + this.y);
	}
}
