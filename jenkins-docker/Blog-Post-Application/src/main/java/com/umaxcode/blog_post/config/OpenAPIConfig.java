package com.umaxcode.blog_post.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Maxwell Odoom",
                        email = "maxwelloddoom1729@gmail.com",
                        url = "umaxcode.com"
                ),
                title = "Blog post webapp",
                description = "Blog post webapp hosted on AWS ECS using CI/CD",
                version = "1.0",
                license = @License(
                        name="Maxwell License",
                        url = "license.max.com"
                ),
                termsOfService = "My Term Of Service"

        )
        ,
        servers = {
                @Server(
                        url = "http://54.87.219.4:8080/",
                        description = "Server For Dev"
                )
        }
)
public class OpenAPIConfig {
}
