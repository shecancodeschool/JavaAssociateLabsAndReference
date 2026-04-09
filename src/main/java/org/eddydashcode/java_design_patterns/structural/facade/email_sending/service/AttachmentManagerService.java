package org.eddydashcode.java_design_patterns.structural.facade.email_sending.service;

import org.eddydashcode.java_design_patterns.structural.facade.email_sending.message.EmailMessage;

public class AttachmentManagerService {

    public void attachFile(EmailMessage message, String filePath) {
        message.addAttachment(filePath);
        System.out.println("Attached file: " + filePath);
    }
}
