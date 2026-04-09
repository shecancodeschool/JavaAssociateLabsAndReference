package org.eddydashcode.java_design_patterns.creational.factory.shape;

import org.eddydashcode.java_design_patterns.creational.factory.shape.factory.CircleFactory;
import org.eddydashcode.java_design_patterns.creational.factory.shape.factory.ShapeFactory;
import org.eddydashcode.java_design_patterns.creational.factory.shape.factory.SquareFactory;
import org.eddydashcode.java_design_patterns.creational.factory.shape.product.Shape;

public class ClientApplication {

    public static void main(String[] args) {
        // create a circle
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.display();


        // create a square
        ShapeFactory squareFactory = new SquareFactory();
        Shape square = squareFactory.createShape();
        square.display();
    }
}
