
package parking.ServerManager;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.auth0.*;

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
    String uid= (String) SessionUtils.get(request, "uid");
    
    DBManager db =new DBManager();
    
    Parking park=db.getParkingById(parking_id);
    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA " + park.getAddress());
    Rental rent=new Rental(123, parking_id, uid, park.getFrom(), park.getTo(), "Jeep");
    park.setOccupied(true);
    db.changeParkingOccupied(park);
    db.addRental(rent);
    System.out.println(uid+" wants to buy parking number "+ parking_id);
    response.sendRedirect("ParkingOrders.html");
    return;
    
  }
}
