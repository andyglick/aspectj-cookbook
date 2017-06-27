package com.oreilly.aspectjcookbook;

public class MainApplication
{

   public static void main(String[] args)
   {
      Window window = new Window();
      
      window.drawText("Some text");
      
      window.drawRect();
      
      Window window2 = new Window();
      
      window2.drawText("Some more text");
      
      window2.drawRect();
   }
}
