package org.eddydashcode.java_design_patterns.structural.decorator.message.decorator;


import org.eddydashcode.java_design_patterns.structural.decorator.message.Message;

public class MessageEncryptionDecorator extends MessageDecorator {

    public MessageEncryptionDecorator(Message messageDecorator) {
        super(messageDecorator);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Message encrypted");
    }
}
