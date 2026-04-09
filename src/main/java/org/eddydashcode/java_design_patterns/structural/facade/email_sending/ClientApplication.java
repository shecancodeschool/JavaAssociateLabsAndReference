package org.eddydashcode.java_design_patterns.structural.facade.email_sending;

import org.eddydashcode.java_design_patterns.structural.facade.email_sending.facade.EmailFacade;

public class ClientApplication {

    public static void main(String[] args) {
        EmailFacade emailFacade = new EmailFacade();

        emailFacade.sendEmail(
                "user@example.com",
                "Welcome!",
                "Thanks for signing up.",
                "welcome.pdf", "terms.pdf"
        );
    }
}
