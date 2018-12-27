package parking.ServerManager;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.client.auth.*;

@WebServlet(urlPatterns = {"/logout1"})
public class LogoutServlet extends HttpServlet {

    /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private AuthAPI auth;
  
  @Override
  public void init(ServletConfig config) throws ServletException {
      super.init(config);
      try {
        auth = AuthenticationControllerProvider.getAuthAPI(config);
      } catch (UnsupportedEncodingException e) {
          throw new ServletException("Couldn't create the AuthenticationController instance. Check the configuration.", e);
      }
  }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse response) throws ServletException, IOException {
        if (req.getSession() != null) {
          req.getSession().invalidate();
        }

        String redirectUri = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/fluent.ly/";
        String url = auth.logoutUrl(redirectUri, true)
            .useFederated(true)
            .build();
        
        response.sendRedirect(url);
    }

}
