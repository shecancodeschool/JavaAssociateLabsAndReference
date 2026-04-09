package org.eddydashcode.java_design_patterns.creational.factory.shape.factory;

import org.eddydashcode.java_design_patterns.creational.factory.shape.product.Shape;
import org.eddydashcode.java_design_patterns.creational.factory.shape.product.Square;

public class SquareFactory implements ShapeFactory{
    @Override
    public Shape createShape() {
        return new Square();
    }
}
