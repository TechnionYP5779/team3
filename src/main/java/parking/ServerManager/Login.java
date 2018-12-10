
package parking.ServerManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    String email = request.getParameter("email");
    String password = request.getParameter("pwd");
    //Some logs to understand this :)
    
    log("-------------------------------");
    log("email is " + email);
    log("password is " + password);
    log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    
    
    //TODO check email and password
    //TODO save cookies
    //TODO redirect to correct page.
    
    try(PrintWriter out = response.getWriter();){
      out.println(HTML_START + "<h2>Hi There!</h2><br/><h3>Email="+ email +"</h3><h3>Password="+ password +"</h3>"+HTML_END);
    }
    
  }
}
