package com.oreilly.aspectjcookbook;

public class MainApplication
{
	public static void main(String[] args)
	{
		// Create the prototype and copy references
		Graphic orig1, orig2, copy1, copy2;
        
        orig1 = new MusicalNote(1,2);
        orig2 = new Staff(3,4); 
        
        System.out.println("Drawing the two prototypes:");
		System.out.print("Prototype1: ");
		orig1.draw();
		System.out.print("Prototype2: ");
        orig2.draw();
        
        copy1 = (Graphic) GraphicPrototypesAspect.aspectOf().cloneObject(orig1);
        copy2 = (Graphic) GraphicPrototypesAspect.aspectOf().cloneObject(orig2);

        System.out.println("Drawing the copies of the prototypes:");
		System.out.print("Copy1: ");
        copy1.draw();
		System.out.print("Copy2: ");
        copy2.draw();

        System.out.println("Changing prototype 1 to different x,y coordinates: x=10, y=20");
        orig1.setX(10);
        orig1.setY(20);
        
        System.out.println("Now prototype 1 was changed.");
        System.out.println("Here we are drawing the prototype and it's former copy");
        System.out.println("Showing that the copying has indeed taken place:");
        System.out.print("Prototype1: ");
        orig1.draw();
		System.out.print("Copy1: ");
        copy1.draw();
	}
}
