package com.oreilly.aspectjcookbook;

public class MainApplication
{

	public static void main(String argv[])
	{
		System.out.print("Creating Composite structure ...");

		Window window1 = new Window("Window1");
		Window window2 = new Window("Window2");

		Line line1 = new Line("Line1");
		Rectangle rectangle1 = new Rectangle("Rectangle1");
		Line line2 = new Line("Line2");
		Line line3 = new Line("Line3");

		GraphicsComposite.aspectOf().addChild(window1, line1);
		GraphicsComposite.aspectOf().addChild(window1, window2);
		GraphicsComposite.aspectOf().addChild(window2, rectangle1);
		GraphicsComposite.aspectOf().addChild(window1, line2);
		GraphicsComposite.aspectOf().addChild(window2, line3);

		System.out.println("Example of working with the top level composite structure");
		System.out.println("Calling draw on Display1");

		window1.draw(System.out);

		System.out.println("Finished calling draw on Display1");

		System.out.println(
			"Example of working with the secondary level composite structure");
		System.out.println("Calling draw on Display2");

		window2.draw(System.out);

		System.out.println("Finished calling draw on Display2");
	}
}
