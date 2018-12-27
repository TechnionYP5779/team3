package parking.ServerManager;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.sqlite.core.*;

import com.google.gson.*;

import parking.db.*;


@WebServlet(
    description = "Park4You getting parameters and sending xml",
    urlPatterns = { "/ParkingsNearby" })
public class ParkingsNearby extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public static final String HTML_START="<html><body>";
  public static final String HTML_END="</body></html>";
  public static final String legalPhoneRegex = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$";

  @Override public void init() throws ServletException {
    //we can create DB connection resource here and set it to Servlet context

  }

  private static double getDistanceFromLatLonInKm(double lat1,double lon1,double lat2,double lon2) {
    double R = 6371; // Radius of the earth in km
    double dLat = deg2rad(lat2-lat1);  // deg2rad below
    double dLon = deg2rad(lon2-lon1);
    double a =
      Math.sin(dLat/2) * Math.sin(dLat/2) +
      Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
      Math.sin(dLon/2) * Math.sin(dLon/2)
      ;
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    double d = R * c; // Distance in km
    return d;
  }

  private static double deg2rad(double deg) {
    return deg * (Math.PI/180);
  }

  @SuppressWarnings("boxing") @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("asfassafasffafs");

   Double radius= Double.parseDouble(request.getParameter("radius"));
   Double lat=Double.parseDouble(request.getParameter("lat"));
   Double lng=Double.parseDouble( request.getParameter("lng"));
   String from= request.getParameter("from");
   String to= request.getParameter("to");
   String date= request.getParameter("date");
   System.out.println("Im hereeee");

   List<Parking> lst = new DBManager().getAllParking();
   String xml="<?xml version=\"1.0\"?><markers>";
   for( Parking parking  : lst) {
     //System.out.println(parking.getFrom());
     double dist = getDistanceFromLatLonInKm(lat, lng, parking.getLat(), parking.getLon());
     if(dist<=radius && parsedDateandHour_getDate(parking.getFrom()).equals(date) && compareHours(from, parsedDateandHour_getHour(parking.getFrom())) && compareHours(parsedDateandHour_getHour(parking.getTo()),to) && new DBManager().getRentalsByParkingId(parking.getParkID()).isEmpty()) {
     xml= xml+ "<marker id=\""+ parking.getParkID()+"\" "+"address=\""+parking.getAddress()+"\" "
     +"from=\""+parking.getFrom()+"\" "+"to=\""+parking.getTo()+"\" "+"price=\""+parking.getPrice()+"\" "+"lat=\""+parking.getLat()+"\" "+"lng=\""+parking.getLon()+"\""+" distance=\""+dist+"\" />";
     }
   }
   xml+="</markers>";
   System.out.println(xml);
   response.setContentType("text/plain");
   response.getWriter().write(xml);


  }


private static String parsedDateandHour_getDate(String dateAndHourQuary) {
  String[] splitStr = dateAndHourQuary.split("\\s+");
  return splitStr[1];
}

private static String parsedDateandHour_getHour(String dateAndHourQuary) {
  String[] splitStr = dateAndHourQuary.split("\\s+");
  return splitStr[0];
}

private static boolean compareHours(String hour1, String hour2) {
  int hours1 = Integer.parseInt(hour1.split(":")[0]); 
  int minutes1 = Integer.parseInt(hour1.split(":")[1]); 
  int hours2 = Integer.parseInt(hour2.split(":")[0]); 
  int minutes2 = Integer.parseInt(hour2.split(":")[1]); 
  
  return (hours1*60+minutes1)>=(hours2*60+minutes2);
  
}


}

/*
<script type="text/javascript">

$(document).ready(function() {
  $.ajax({
    type: "POST",
    url : 'GetUsersForRent',
    data : {
    },
    success : function(response) {
      console.log(response);
      parkings = JSON.parse(response);
      new_html = "";
      for (var i in parkings) {
        console.log(parkings[i]);
        new_html += ...
      }
      $("#parkings_table").html(new_html);
    }
  });
});
</script>
*/
