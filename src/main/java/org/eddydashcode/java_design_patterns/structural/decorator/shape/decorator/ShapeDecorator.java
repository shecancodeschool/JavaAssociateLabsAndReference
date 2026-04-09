package org.eddydashcode.java_design_patterns.structural.decorator.shape.decorator;

import org.eddydashcode.java_design_patterns.structural.decorator.shape.Shape;

public abstract class ShapeDecorator implements Shape {

    private final Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
