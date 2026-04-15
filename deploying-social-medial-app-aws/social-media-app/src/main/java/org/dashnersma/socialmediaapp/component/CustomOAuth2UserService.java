package org.dashnersma.socialmediaapp.component;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.umaxcodesma.socialmediaapp.domain.entity.User;
import org.umaxcodesma.socialmediaapp.repository.UserRepository;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println(userRequest + " Oauth2");
        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println(oAuth2User.getAttributes());
        Map<String, Object> attributes = oAuth2User.getAttributes();

        String username = (String) attributes.get("login");
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
        return oAuth2User;
    }
}
