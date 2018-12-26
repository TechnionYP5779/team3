package parking.ServerManager;

import com.auth0.AuthenticationController;

import javax.servlet.ServletConfig;

public abstract class AuthenticationControllerProvider {

    public static AuthenticationController getInstance(ServletConfig config) {
        String domain = config.getServletContext().getInitParameter("com.auth0.domain");
        String clientId = config.getServletContext().getInitParameter("com.auth0.clientId");
        String clientSecret = config.getServletContext().getInitParameter("com.auth0.clientSecret");

        return AuthenticationController.newBuilder(domain, clientId, clientSecret)
                .build();
    }
}
