package org.eddydashcode.java_design_patterns.structural.decorator.shape;

public class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}
