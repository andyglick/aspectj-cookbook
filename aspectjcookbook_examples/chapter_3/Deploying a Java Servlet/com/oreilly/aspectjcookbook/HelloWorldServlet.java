import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet
{
   public void doGet (HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
   {
      response.setContentType("text/html");
      ServletOutputStream out = response.getOutputStream();
      out.println("<html>");
      out.println("<head><title>Normal Title created by a servlet!</title></head>");
      out.println("<body>");
      out.println("<h1>Hello World a normal Java Servlet!</h1>");
      out.println("</body>");
      out.println("</html>");
   }
   
   public String getServletInfo() 
   {
      return "Create a page that says <i>Hello World</i> and send it back";
   }
}
