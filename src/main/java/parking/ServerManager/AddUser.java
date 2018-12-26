
package parking.ServerManager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import parking.db.*;

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
    request.setAttribute("username", userName);
    request.setAttribute("firstName", firstName);
    request.setAttribute("lastName", lastName);
    request.setAttribute("phoneNumber", phoneNumber);
    String errorMessage = "";
    if(!phoneNumber.matches(legalPhoneRegex))
      errorMessage += "Illegal phone number<br/>";
    if(firstName.isEmpty())
      errorMessage += "Please enter your first name<br/>";
    if(lastName.isEmpty())
      errorMessage += "Please enter your last name<br/>";
    if(userName.isEmpty())
      errorMessage += "Please enter your username<br/>";
    if(DBManager.getUserByUsername(userName) != null)
      errorMessage += "Username taken<br/>";
    
    if (!errorMessage.isEmpty()) {
      request.setAttribute("errorMessage", errorMessage);
      RequestDispatcher rd = request.getRequestDispatcher("adduser.jsp");
      rd.forward(request, response);
      return;
    }
    
    //TODO save to DB, if failed return something
    
    User u = new User(-1, userName, firstName, lastName, phoneNumber, password);
    
    DBManager.addUser(u);
    u = DBManager.getUserByUsername(userName);
    
    //TODO maybe change to user id?
    Cookie user = new Cookie("user", userName);
    //TODO set expire right
    user.setMaxAge(60*60*24);
    Cookie uid = new Cookie("uid", "" + u.getUserID());
    response.addCookie( uid );
    response.addCookie( user );
    
    response.sendRedirect("homePage.html");
    return;
    
  }
}
