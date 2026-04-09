package org.eddydashcode.java_design_patterns.structural.facade.email_sending.facade;

import org.eddydashcode.java_design_patterns.structural.facade.email_sending.message.EmailMessage;
import org.eddydashcode.java_design_patterns.structural.facade.email_sending.service.AttachmentManagerService;
import org.eddydashcode.java_design_patterns.structural.facade.email_sending.service.EmailComposerService;
import org.eddydashcode.java_design_patterns.structural.facade.email_sending.service.SMTPService;

public class EmailFacade {

    private final EmailComposerService composer = new EmailComposerService();
    private final AttachmentManagerService attachmentManager = new AttachmentManagerService();
    private final SMTPService smtpService = new SMTPService();

    public void sendEmail(String to, String subject, String body, String... attachments) {
        EmailMessage message = composer.compose(to, subject, body);
        for (String filePath : attachments) {
            attachmentManager.attachFile(message, filePath);
        }
        smtpService.sendEmail(message);
    }
}
