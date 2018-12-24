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
  
  private static void alert_error(String msg, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("errorMessage", msg);
    RequestDispatcher rd = request.getRequestDispatcher("addpark.jsp");
    rd.forward(request, response);
    return;
  }

  
  @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  //get parameters

<<<<<<< HEAD
    System.out.println("AAAAAAAAAA");
=======
    System.out.println("meowmeowmeow");
>>>>>>> master
    String from = request.getParameter("FromHour");
    
    String to = request.getParameter("ToHour");
<<<<<<< HEAD
    String lat1 = request.getParameter("lat");
    String lng1 = request.getParameter("lng");
    System.out.println("BBBBBBBBBBBB");
   

=======
    
>>>>>>> master
    String date = request.getParameter("date");
    String address = request.getParameter("Address");
    String price_string = request.getParameter("price");
    if (from == null || from.equals("") || 
        to == null || to.equals("") ||
            date == null || date.equals("") ||
                address == null || address.equals("") ||
                    price_string == null || price_string.equals("")) {
      alert_error("Please fill all fields", request, response);
      return;
    }
    
    int price = 0;
    try {
        price = Integer.parseInt(price_string);
    }
    catch (NumberFormatException e) {
      alert_error("Please enter a positive number as price", request, response);
      return;
    }
    if (price <= 0) {
      alert_error("Please enter a positive number as price", request, response);
      return;
    }
    double lat = 0;
    double lon = 0;
    try {
         lat = Double.parseDouble(request.getParameter("lat"));
         lon = Double.parseDouble(request.getParameter("lng"));
    }
    catch (NumberFormatException e) {
      alert_error("Address not found", request, response);
      return;
    }

    System.out.println("params are:" + address + "" + lon + "" + lat +"" +price);
    
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
    Parking p = new Parking(-1, uid, address, lat, lon, from + " " + date, to + " " + date, price);
    new DBManager().addParking(p);
    
    // redirect to correct page.
    response.sendRedirect("parkTable.html");
    
    
  }
}
