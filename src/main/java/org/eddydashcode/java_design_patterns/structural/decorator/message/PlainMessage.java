package org.eddydashcode.java_design_patterns.structural.decorator.message;

public class PlainMessage implements Message {
    @Override
    public void display() {
        System.out.println("This is a plain message");
    }
}
