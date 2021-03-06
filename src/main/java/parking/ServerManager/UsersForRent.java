package parking.ServerManager;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.auth0.*;
import com.google.gson.*;

import parking.db.*;


@WebServlet(
    description = "Park4You Add User", 
    urlPatterns = { "/GetUsersForRent" })
public class UsersForRent extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public static final String HTML_START="<html><body>";
  public static final String HTML_END="</body></html>";
  public static final String legalPhoneRegex = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$";
         
  
  @Override public void init() throws ServletException {
    //we can create DB connection resource here and set it to Servlet context
    
  }
  
  @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //TODO get cookie and check user logged in
    //TODO get from user cookie a list of parkings
    //TODO Gson.toJson
    //System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB Working Directory = " +
    //System.getProperty("user.dir"));
    Cookie[] cookies = request.getCookies();
    String uid = (String) SessionUtils.get(request, "uid");
    /*
    for(Cookie c : cookies)
    {
      System.out.println(c.getName());
      if(c.getName().equals("uid"))
      {
        uid = Integer.parseInt(c.getValue());
        break;
      }
    }*/
    System.out.println(uid);
   List<Parking> parkings = new DBManager().getParking(uid);
   for (Parking p : parkings) {
     p.setOccupied(new DBManager().getRentalsByParkingId(p.getParkID()).isEmpty() ? false: true);
   }
   
    String json_response = new Gson().toJson(parkings); //"[{\"Address\" : \"Haifa\", \"Date\" : \"01.01.0000\", \"Price\" : \"52\",\"Hours\" : \"12:00-13:00\", \"Occupied\" : \"No\"}, {\"Address\" : \"Haifa\",\"Date\" : \"01.01.0000\", \"Price\" : \"52\", \"Hours\" : \"12:00-13:00\", \"Occupied\" : \"No\"}, {\"Address\" : \"Haifa\", \"Date\" : \"01.01.0000\", \"Price\" : \"52\",\"Hours\" : \"12:00-13:00\", \"Occupied\" : \"No\"}]";
    //System.out.println(json_response);
    response.setContentType("text/plain");
    response.getWriter().write(json_response);
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