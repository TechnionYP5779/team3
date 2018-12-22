
package parking.ServerManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import parking.db.*;

/**
 * Servlet Tutorial - Servlet Example
 */
@WebServlet(
    description = "Park4You Add Park Spot", 
    urlPatterns = { "/AddParkSpot" })
public class AddParkSpot extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public static final String HTML_START="<html><body>";
  public static final String HTML_END="</body></html>";
       
    
  @Override public void init() throws ServletException {
    //we can create DB connection resource here and set it to Servlet context
    
  }

  
  @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  //get parameters
    
    
    String from = request.getParameter("FromHour");
    String to = request.getParameter("ToHour");
    String date = request.getParameter("date");
    int price = Integer.parseInt(request.getParameter("price"));
    
    //TODO get real address from google maps search
    String address = "fake place";
    double lat = 0.0;
    double lon = 0.0;
    
    //getting user id cookie
    Cookie[] cookies = request.getCookies();
    int uid = -1;
    
    for(Cookie c : cookies)
    {
      System.out.println(c.getName());
      if(c.getName().equals("uid"))
      {
        uid = Integer.parseInt(c.getValue());
        break;
      }
    }
    //save to DB
    Parking p = new Parking(-1, uid, address, lat, lon, from, to, price);
    new DBManager().addParking(p);
    
    // redirect to correct page.
    response.sendRedirect("parkTable.html");
    
    
  }
}
