package parking.ServerManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet Tutorial - Servlet Example
 */
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
    String json_response = "[{\"Address\" : \"Haifa\", \"Date\" : \"01.01.0000\", \"Price\" : \"52\",\"Hours\" : \"12:00-13:00\", \"Occupied\" : \"No\"}, {\"Address\" : \"Haifa\",\"Date\" : \"01.01.0000\", \"Price\" : \"52\", \"Hours\" : \"12:00-13:00\", \"Occupied\" : \"No\"}, {\"Address\" : \"Haifa\", \"Date\" : \"01.01.0000\", \"Price\" : \"52\",\"Hours\" : \"12:00-13:00\", \"Occupied\" : \"No\"}]";
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