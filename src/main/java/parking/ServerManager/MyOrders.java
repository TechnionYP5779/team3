package parking.ServerManager;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.*;

import parking.db.*;

/**
 * Servlet implementation class MyOrders
 */
@WebServlet("/GetMyOrders")
public class MyOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyOrders() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
	  List<Rental> parkings = new DBManager().getRentalsByRenter(uid);
	  String json_response = new Gson().toJson(parkings);
    //System.out.println(json_response);
    response.setContentType("text/plain");
    response.getWriter().write(json_response);
	}

}
