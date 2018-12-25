
package parking.ServerManager;

import java.io.*;

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
    urlPatterns = { "/Buy" })
public class Buy extends HttpServlet {
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
    Integer parking_id = Integer.parseInt(request.getParameter("foo"));
    
    Cookie[] cookies = request.getCookies();
    String username=null;

    for (int i = 0; i < cookies.length; i++) {
      String name = cookies[i].getName();
      if(name.equals("uid")) {
          username= cookies[i].getValue();
          break;
      }
      
      
    };
    Integer user_id=Integer.parseInt(username);
   
    DBManager db=new DBManager();
    Parking park=db.getParkingById(parking_id);
    Rental rent=new Rental(123,parking_id,user_id,park.getFrom(),park.getTo(),"Jeep");
    
    db.addRental(rent);
    System.out.println(username+" wants to buy parking number "+ parking_id);
    response.sendRedirect("ParkingOrders.html");

    
    
    ///adding here a DB manager func

    

   
    return;
    
  }
}
