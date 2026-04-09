package org.eddydashcode.java_design_patterns.structural.decorator.message.decorator;

import org.eddydashcode.java_design_patterns.structural.decorator.message.Message;

public abstract class MessageDecorator implements Message {

    private final Message messageDecorator;

    public MessageDecorator(Message messageDecorator) {
        this.messageDecorator = messageDecorator;
    }

    @Override
    public void display() {
        messageDecorator.display();
    }
}
