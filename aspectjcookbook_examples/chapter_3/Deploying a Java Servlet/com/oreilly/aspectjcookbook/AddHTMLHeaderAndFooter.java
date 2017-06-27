package com.oreilly.aspectjcookbook;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public aspect AddHTMLHeaderAndFooter 
{
   public pointcut captureHttpRequest(HttpServletRequest request, HttpServletResponse response) : 
      execution(public void AOHelloWorldServlet.doGet(HttpServletRequest, HttpServletResponse)) && 
      args(request, response);
   
   // Could have used around with proceed but for performance reasons as described in the pointcut chapters
   // it is preferrable wherever thinsg are not too disruptive to use before and after instead.
   before(HttpServletRequest request, HttpServletResponse response) throws IOException : captureHttpRequest(request, response)
   {
      response.setContentType("text/html");
      ServletOutputStream out = response.getOutputStream();
      out.println("<html>");
      out.println("<head><title>Adding a title using AspectJ!</title></head>");
      out.println("<body>");
   }
   
   after(HttpServletRequest request, HttpServletResponse response) throws IOException : captureHttpRequest(request, response)
   {
      ServletOutputStream out = response.getOutputStream();
      out.println("</body>");
      out.println("</html>");
   }
}
