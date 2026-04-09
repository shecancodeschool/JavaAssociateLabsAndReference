package org.eddydashcode.java_design_patterns.structural.decorator.shape.decorator;

import org.eddydashcode.java_design_patterns.structural.decorator.shape.Shape;

public class BorderColorDecorator extends ShapeDecorator{
    private final String color;

    public BorderColorDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Border color: " + color);
    }
}
