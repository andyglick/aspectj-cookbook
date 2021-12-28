package com.oreilly.aspectjcookbook;

public class MainApplication
{
  public static void main(String[] args)
  {
	System.out.println("Creating and using a TextDisplay object that has not been decorated");
	TextDisplay textDisplay1 = new TextDisplay();
	textDisplay1.display("Text Displayed by undecorated object\n");
	
	System.out.println("Creating and using a TextDisplay object that has been decorated");
    TextDisplay textDisplay2 = new TextDisplay();
    textDisplay2.setDecorated(true);
    textDisplay2.display("\nText Displayed by decorated object\n");
  }
}
