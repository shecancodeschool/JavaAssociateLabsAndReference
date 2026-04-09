package org.eddydashcode.java_design_patterns.structural.facade.email_sending.service;

import org.eddydashcode.java_design_patterns.structural.facade.email_sending.message.EmailMessage;

public class SMTPService {

    public void sendEmail(EmailMessage message) {
        System.out.println("Sending email to: " + message.getTo());
        System.out.println("Subject: " + message.getSubject());
        System.out.println("Body: " + message.getBody());
        if (!message.getAttachments().isEmpty()) {
            System.out.println("Attachments: " + message.getAttachments());
        }
        System.out.println("Email sent successfully!");
    }
}
