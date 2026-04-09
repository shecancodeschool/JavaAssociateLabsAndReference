package org.umaxcodesma.socialmediaapp;

import org.springframework.boot.SpringApplication;

public class TestSocialMediaAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(SocialMediaAppApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
