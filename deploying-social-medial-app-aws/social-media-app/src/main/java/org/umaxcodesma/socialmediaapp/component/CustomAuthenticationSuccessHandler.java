package org.umaxcodesma.socialmediaapp.component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.umaxcodesma.socialmediaapp.service.JwtService;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Value("${application.frontend.baseUrl}")
    private String frontedBaseUrl;

    private final JwtService jwtService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Object principal = authentication.getPrincipal();

        String username;

        if (principal instanceof OidcUser oidcUser) {
            username = oidcUser.getName(); // or oidcUser.getSubject(), or getName()
        } else if (principal instanceof OAuth2User oAuth2User) {
            username = oAuth2User.getName();
        } else {
            username = "Anonymous_User";
        }


        String token = jwtService.generateToken(username);

        // Redirect to frontend with token
        String redirectUrl = frontedBaseUrl + "?token=" + token;
        response.sendRedirect(redirectUrl);
    }
}
