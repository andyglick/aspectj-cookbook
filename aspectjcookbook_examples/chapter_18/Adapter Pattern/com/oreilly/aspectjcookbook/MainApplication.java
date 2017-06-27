package com.oreilly.aspectjcookbook;

public class MainApplication
{
  public static void main(String[] args)
  {
    Screen screen = new Screen();

    screen.outputToScreen("Traditional Message to native Screen class method");

    screen.print(
      "Message to call added to adapt the Screen class to the Printer interface");
   }
}
