package org.eddydashcode.java_design_patterns.structural.facade.email_sending.service;

import org.eddydashcode.java_design_patterns.structural.facade.email_sending.message.EmailMessage;

public class EmailComposerService {

    public EmailMessage compose(String to, String subject, String body) {
        EmailMessage message = new EmailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setBody(body);
        System.out.println("Composed email to: " + to);
        return message;
    }
}
