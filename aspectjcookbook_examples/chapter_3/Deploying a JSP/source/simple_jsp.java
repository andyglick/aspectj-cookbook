import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

public class simple_jsp extends HttpJspBase {


  private static java.util.Vector _jspx_includes;

  public java.util.List getIncludes() {
    return _jspx_includes;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    javax.servlet.jsp.PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\r\n");
      out.write("<body bgcolor=\"white\">\r\n");
      out.write("<h1> Request Information ");
      out.write("</h1>\r\n");
      out.write("<font size=\"4\">\r\nJSP Request Method: ");
      out.print( request.getMethod() );
      out.write("\r\n");
      out.write("<br>\r\nRequest URI: ");
      out.print( request.getRequestURI() );
      out.write("\r\n");
      out.write("<br>\r\nRequest Protocol: ");
      out.print( request.getProtocol() );
      out.write("\r\n");
      out.write("<br>\r\nServlet path: ");
      out.print( request.getServletPath() );
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("</font>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      out = _jspx_out;
      if (out != null && out.getBufferSize() != 0)
        out.clearBuffer();
      if (pageContext != null) pageContext.handlePageException(t);
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);
    }
  }
}
