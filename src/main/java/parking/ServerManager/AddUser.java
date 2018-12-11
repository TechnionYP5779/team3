
package parking.ServerManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet Tutorial - Servlet Example
 */
@WebServlet(
    description = "Park4You Add User", 
    urlPatterns = { "/AddUser" })
public class AddUser extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public static final String HTML_START="<html><body>";
  public static final String HTML_END="</body></html>";
  public static final String legalPhoneRegex = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$";
       
    
  @Override public void init() throws ServletException {
    //we can create DB connection resource here and set it to Servlet context
    
  }

  
  @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("adduser.jsp");
  }
  
  @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  //get parameters
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String phoneNumber = request.getParameter("phoneNumber");
    String userName = request.getParameter("userName");
    String password = request.getParameter("pwd");
    
    if (!phoneNumber.matches(legalPhoneRegex)) {
      request.setAttribute("errorMessage", "Illegal phone number");
      RequestDispatcher rd = request.getRequestDispatcher("adduser.jsp");
      rd.forward(request, response);
      return;
    }
    
    //TODO save to DB, if failed return something
    
    //TODO maybe change to user id?
    Cookie user = new Cookie("user", userName);
    //TODO set expire right
    user.setMaxAge(60*60*24);
    response.addCookie( user );
    //TODO redirect to correct page.
    response.sendRedirect("tmpLogged.jsp");
    return;
    
    
    //TODO
    /* for errors add in jsp:
     <%
      if(request.getAttribute("errorMessage") != null){
     %>
      <label style="color:red;"><%=request.getAttribute("errorMessage")%></label>
      
     <%
      }
     %>
     */
  }
}
