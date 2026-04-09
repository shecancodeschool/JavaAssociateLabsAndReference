package org.eddydashcode.java_design_patterns.structural.decorator.shape;

import org.eddydashcode.java_design_patterns.structural.decorator.shape.decorator.BorderColorDecorator;
import org.eddydashcode.java_design_patterns.structural.decorator.shape.decorator.TransparencyDecorator;

public class ClientApplication {

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new BorderColorDecorator(circle, "Red");
        Shape transparentRedCircle = new TransparencyDecorator(redCircle, 0.5);

        System.out.println("Base Circle: ");
        circle.draw();

        System.out.println();

        System.out.println("Circle with Red Border: ");
        redCircle.draw();

        System.out.println();

        System.out.println("Circle with Red Border and Transparency");
        transparentRedCircle.draw();
    }
}
