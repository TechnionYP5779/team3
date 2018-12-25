
package parking.ServerManager;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import parking.db.*;


/**
 * Servlet Tutorial - Servlet Example
 */
@WebServlet(
    description = "Park4You Login", 
    urlPatterns = { "/Login" })
public class Login extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public static final String HTML_START="<html><body>";
  public static final String HTML_END="</body></html>";
       
    
  @Override public void init() throws ServletException {
    //we can create DB connection resource here and set it to Servlet context
    
  }

  
  @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //get parameters
    String userName = request.getParameter("userName");
    String password = request.getParameter("pwd");
    //Some logs to understand this :)
    
    log("-------------------------------");
    log("user is " + userName);
    log("password is " + password);
    log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    
    User u = new DBManager().getUserByUsername(userName);
    
    if(u == null || !u.getPassword().equals(password))
    {
      //user not found
      request.setAttribute("errorMessage", "No such username/password");
      request.setAttribute("username", userName);
      RequestDispatcher rd = request.getRequestDispatcher("loginUser.jsp");
      rd.forward(request, response);
      return;
    }
    
    
    //TODO check username and password
    //TODO maybe change to user id?
    Cookie user = new Cookie("user", userName);
    //TODO set expire right
    user.setMaxAge(60*60*24);
    response.addCookie( user );
    Cookie uid = new Cookie("uid", "" + u.getUserID());
    response.addCookie( uid );
    response.sendRedirect("homePage.html");
    return; 
  }
}
