package org.eddydashcode.java_design_patterns.structural.facade.email_sending.message;

import java.util.ArrayList;
import java.util.List;

public class EmailMessage {

    private String to;
    private String subject;
    private String body;
    private final List<String> attachments = new ArrayList<>();

    public void setTo(String to) {
        this.to = to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void addAttachment(String filePath) {
        attachments.add(filePath);
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public List<String> getAttachments() {
        return attachments;
    }
}
