package parking.ServerManager;

import com.auth0.AuthenticationController;
import com.auth0.client.auth.*;

import javax.servlet.ServletConfig;
import java.io.UnsupportedEncodingException;

public abstract class AuthenticationControllerProvider {

    public static AuthenticationController getInstance(ServletConfig config) throws UnsupportedEncodingException {
        String domain = config.getServletContext().getInitParameter("com.auth0.domain");
        String clientId = config.getServletContext().getInitParameter("com.auth0.clientId");
        String clientSecret = config.getServletContext().getInitParameter("com.auth0.clientSecret");

        return AuthenticationController.newBuilder(domain, clientId, clientSecret)
                .build();
    }
    public static AuthAPI getAuthAPI(ServletConfig config) throws UnsupportedEncodingException {
      String domain = config.getServletContext().getInitParameter("com.auth0.domain");
      String clientId = config.getServletContext().getInitParameter("com.auth0.clientId");
      String clientSecret = config.getServletContext().getInitParameter("com.auth0.clientSecret");

      return new AuthAPI(domain, clientId, clientSecret);
  }
}
