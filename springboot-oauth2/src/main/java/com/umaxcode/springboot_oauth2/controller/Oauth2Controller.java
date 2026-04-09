package com.umaxcode.springboot_oauth2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Oauth2Controller {

    @GetMapping("/free")
    public String publicPage() {
        return "public"; // maps to templates/public.html
    }

    @GetMapping("/secure")
    public String securePage(Model model, @AuthenticationPrincipal OidcUser principal,
                             @RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient authorizedClient) {
        System.out.println("Access token: " + authorizedClient.getAccessToken().getTokenValue());

        if (principal != null) {
            System.out.println("Id Token: " + principal.getIdToken().getTokenValue());
            model.addAttribute("name", principal.getAttribute("name"));
            model.addAttribute("email", principal.getAttribute("email"));
        }
        return "secure"; // maps to templates/secure.html
    }

    @GetMapping("/resource-server-data")
    @ResponseBody
    public String getProtectedData() {
        return "This is a protect data";
    }
}
