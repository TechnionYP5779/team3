
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
    String city = request.getParameter("city");
    String street = request.getParameter("street");
    String BuildNum = request.getParameter("BuildNum");
    String date = request.getParameter("date");
    String FromHour = request.getParameter("FromHout");
    String ToHour = request.getParameter("ToHour");
    
    //TODO save to DB
    //TODO redirect to correct page.
    
    try(PrintWriter out = response.getWriter();){
      out.println(HTML_START + "<h2>Hi There!</h2><br/><h3>city="+ city +"</h3><h3>street="+ street +"</h3><h3>building="+BuildNum + "</h3><h3>date=" +date+"</h3><h3>from=" + FromHour + "</h3><h3>to=" + ToHour + "</h3>"+HTML_END);
    }
    
  }
}
