package org.dashnersma.socialmediaapp.component;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;
import org.umaxcodesma.socialmediaapp.domain.entity.User;
import org.umaxcodesma.socialmediaapp.repository.UserRepository;

import java.util.Map;


@Component
@RequiredArgsConstructor
public class CustomOidcUserService extends OidcUserService {

    private final UserRepository userRepository;

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println(userRequest + " Oidc");
        OidcUser oidcUser = super.loadUser(userRequest);
        System.out.println(oidcUser.getAttributes());
        Map<String, Object> attributes = oidcUser.getAttributes();

        String username = (String) attributes.get("sub");
        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");


        userRepository.findByUsername(username)
                .orElseGet(() -> {
                    User userInstance = User.builder()
                            .username(username)
                            .email(email)
                            .fullName(name)
                            .build();
                    return userRepository.save(userInstance);
                });

        return oidcUser;
    }
}
