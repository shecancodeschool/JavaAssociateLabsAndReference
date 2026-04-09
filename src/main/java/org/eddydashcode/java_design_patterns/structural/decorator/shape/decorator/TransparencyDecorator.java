package org.eddydashcode.java_design_patterns.structural.decorator.shape.decorator;

import org.eddydashcode.java_design_patterns.structural.decorator.shape.Shape;

public class TransparencyDecorator extends ShapeDecorator {
    private final double opacity;

    public TransparencyDecorator(Shape decoratedShape, double opacity) {
        super(decoratedShape);
        this.opacity = opacity;
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Transparency set to: " + opacity);
    }
}
