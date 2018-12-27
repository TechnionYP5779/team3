
package parking.ServerManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.auth0.AuthenticationController;
import javax.servlet.ServletConfig;
import java.io.UnsupportedEncodingException;
/**
 * Servlet Tutorial - Servlet Example
 */
@WebServlet(
    description = "Park4You Login", 
    urlPatterns = { "/Login1" })
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public static final String HTML_START="<html><body>";
  public static final String HTML_END="</body></html>";
  private AuthenticationController authenticationController;
  private String domain;
  //we can create DB connection resource here and set it to Servlet context
  @Override
  public void init(ServletConfig config) throws ServletException {
      super.init(config);
      domain = config.getServletContext().getInitParameter("com.auth0.domain");
      try {
          authenticationController = AuthenticationControllerProvider.getInstance(config);
      } catch (UnsupportedEncodingException e) {
          throw new ServletException("Couldn't create the AuthenticationController instance. Check the configuration.", e);
      }
  }

  @Override
  protected void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
      String redirectUri = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/fluent.ly/callback";
      log("redirect uri:" + redirectUri);
      String authorizeUrl = authenticationController.buildAuthorizeUrl(req, redirectUri)
              .withAudience(String.format("https://%s/userinfo", domain))
              .build();
      log("authorize ulr:" + authorizeUrl);
      res.sendRedirect(authorizeUrl);
  }

  
  @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String redirectUri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/fluent.ly/callback";

    String authorizeUrl = authenticationController.buildAuthorizeUrl(request, redirectUri)
            .withAudience(String.format("https://%s/userinfo", domain))
            .build();
    response.sendRedirect(authorizeUrl);
/*
    //get parameters
    String userName = request.getParameter("userName");
    String password = request.getParameter("pwd");
    //Some logs to understand this :)
    
    log("-------------------------------");
    log("user is " + userName);
    log("password is " + password);
    log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    
    
    //TODO check username and password
    //TODO maybe change to user id?
    Cookie user = new Cookie("user", userName);
    //TODO set expire right
    user.setMaxAge(60*60*24);
    response.addCookie( user );
    response.sendRedirect("homePage.html");
    return; */
  }
}
