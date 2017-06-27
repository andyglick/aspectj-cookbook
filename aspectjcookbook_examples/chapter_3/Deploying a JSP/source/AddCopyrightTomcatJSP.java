import javax.servlet.jsp.JspWriter;

public aspect AddCopyrightTomcatJSP 
{
   public pointcut captureOutput(String message, JspWriter writer) : 
      call(public void JspWriter.write(String) ) && 
      within(simple_jsp) &&
      args(message) &&
      target(writer) &&
      if (message.equals("</body>\r\n"));
   
   before(String message, JspWriter writer) : captureOutput(message, writer)
   {
      try
      {
        writer.write("<p>Copyleft Russ Miles 2004</p>\n");
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
