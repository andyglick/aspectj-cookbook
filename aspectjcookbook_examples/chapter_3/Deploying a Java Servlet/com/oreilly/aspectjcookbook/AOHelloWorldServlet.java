package com.oreilly.aspectjcookbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AOHelloWorldServlet extends HttpServlet
{
   public void doGet (HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
   {
      ServletOutputStream out = response.getOutputStream();
      out.println("<h1>Hello World from an aspect-oriented Servlet!</h1>");
   }
   
   public String getServletInfo() 
   {
      return "Create a page that says <i>Hello World</i> and send it back";
   }
}
