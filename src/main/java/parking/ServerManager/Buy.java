
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
    }
    
    Integer user_id = Integer.parseInt(username);
    
    DBManager db =new DBManager();
    String fromRequest= request.getParameter("FromHour");
    String toRequest= request.getParameter("ToHour");
    
    Parking park=db.getParkingById(parking_id);
    String fromParking = parsedDateandHour_getHour(park.getFrom()); 
    String toParking = parsedDateandHour_getHour(park.getTo()); 
    String dateFrom =  parsedDateandHour_getDate(park.getFrom()); 
    String dateTo =  parsedDateandHour_getDate(park.getTo());
    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA " + park.getAddress());
    if((hoursDiff(fromRequest,fromParking) >=60 || hoursDiff(fromRequest, fromParking) == 0 ) && (hoursDiff(toParking, toRequest) >=60 || hoursDiff(toRequest,  toParking) ==  0 )  ) {
      //delete parkig 
      db.removeParking(park);
      //update the part of the time that rented
      park.setFrom(fromRequest);
      park.setTo(toRequest);
      park.setOccupied(true);
      db.addParking(park);
      
      if(hoursDiff(fromRequest, fromParking) != 0 ) {
        //add new parking spot for the time before the new rent 
         Parking parkingSplitFirst = new Parking(-1, park.getUserID(), park.getAddress(), park.getLat(), park.getLon(), fromParking + " " + dateFrom, fromRequest + " " + dateTo, park.getPrice(), false);
         db.addParking(parkingSplitFirst);
      }
      if(hoursDiff(toParking, toRequest) != 0) {
        //add new parking spot for the time after the new rent 
        Parking parkingSplitSecond = new Parking(-1, park.getUserID(), park.getAddress(), park.getLat(), park.getLon(), toRequest + " " + dateFrom, toParking + " " + dateTo, park.getPrice(), false);
        db.addParking(parkingSplitSecond);
      }
      //add new rented parking to rented table
      Rental rent=new Rental(123, parking_id, user_id, park.getFrom(), park.getTo(), "Jeep");
      db.addRental(rent);
      
      System.out.println(username+" wants to buy parking number "+ parking_id);
      response.sendRedirect("ParkingOrders.html");
    }else {
      PrintWriter pw = response.getWriter(); 
      pw.println("<script type=\"text/javascript\">");
      pw.println("alert('Can not leave a span of less than an hour!');");
      pw.println("</script>");
    }
    return;
    
  }
  private static int hoursDiff(String hour1, String hour2) {
    int hours1 = Integer.parseInt(hour1.split(":")[0]); 
    int minutes1 = Integer.parseInt(hour1.split(":")[1]); 
    int hours2 = Integer.parseInt(hour2.split(":")[0]); 
    int minutes2 = Integer.parseInt(hour2.split(":")[1]); 
    
    return (hours1*60+minutes1)-(hours2*60+minutes2);
}
  private static String parsedDateandHour_getDate(String dateAndHourQuary) {
    String[] splitStr = dateAndHourQuary.split("\\s+");
    return splitStr[1];
  }

  private static String parsedDateandHour_getHour(String dateAndHourQuary) {
    String[] splitStr = dateAndHourQuary.split("\\s+");
    return splitStr[0];
  }

}
