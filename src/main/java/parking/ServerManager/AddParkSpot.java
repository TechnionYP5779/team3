
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

    String Address = request.getParameter("Address");
    String lat = request.getParameter("lat");
    String lng = request.getParameter("lng");
    String date = request.getParameter("date");
    String FromHour = request.getParameter("FromHour");
    String ToHour = request.getParameter("ToHour");
    
    //TODO get cookie and check user logged in
    //TODO save to DB
    //TODO redirect to correct page.
    
    try(PrintWriter out = response.getWriter();){
      out.println(HTML_START +"</h3><h3>lat="+lat + "</h3><h3>lng="+lng +"</h3><h3>Address="+Address + "</h3><h3>date=" +date+"</h3><h3>from=" + FromHour + "</h3><h3>to=" + ToHour + "</h3>"+HTML_END);
    }
    
  }
}
