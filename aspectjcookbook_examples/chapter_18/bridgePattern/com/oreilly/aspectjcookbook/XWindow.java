
package com.oreilly.aspectjcookbook;

public class XWindow
{
   public void drawText(String text)
   {
      System.out.println("Text Drawn using XWindow(" + this + "):");
      System.out.println(text);
   }
   
   public void drawLine()
   {
      System.out.println("Drawing line using XWindow(" + this + ")");
   }
}
