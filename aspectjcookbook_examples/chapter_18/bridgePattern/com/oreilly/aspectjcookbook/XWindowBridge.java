package com.oreilly.aspectjcookbook;


public aspect XWindowBridge perthis(captureAllBridgedCalls())
{
      private XWindow imp = new XWindow();
      
      public pointcut captureDrawText(String text) : execution(public void Window.drawText(String)) && args(text);
      
      public pointcut captureDrawRect() : execution(public void Window.drawRect());
      
      public pointcut captureAllBridgedCalls() : captureDrawText(String) || captureDrawRect();
      
      void around(String text) : captureDrawText(text)
      {
         imp.drawText(text);
      }
      
      void around() : captureDrawRect()
      {
         imp.drawLine();
         imp.drawLine();
         imp.drawLine();
         imp.drawLine();
      }
}
