package com.oreilly.aspectjcookbook;

public aspect PrinterScreenAdapter 
{
  declare parents : Screen implements Printer;

  public void Screen.print(String s)
  {
    outputToScreen(s);
  }
}