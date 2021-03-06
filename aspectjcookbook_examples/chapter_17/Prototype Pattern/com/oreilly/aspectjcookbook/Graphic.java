package com.oreilly.aspectjcookbook;

public abstract class Graphic
{
	protected int x,y;
	
	public Graphic(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public abstract void draw();
	
	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}
}
