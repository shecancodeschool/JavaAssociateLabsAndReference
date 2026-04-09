package org.eddydashcode.java_design_patterns.creational.factory.shape.factory;

import org.eddydashcode.java_design_patterns.creational.factory.shape.product.Circle;
import org.eddydashcode.java_design_patterns.creational.factory.shape.product.Shape;

public class CircleFactory implements ShapeFactory{
    @Override
    public Shape createShape() {
        return new Circle();
    }
}
