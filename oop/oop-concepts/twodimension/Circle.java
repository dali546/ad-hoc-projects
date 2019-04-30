package twodimension;

import interfaces.Shape;
import interfaces.TwoDimensionalShape;

public class Circle implements TwoDimensionalShape, Shape {

    private double radius;
    private String colour;

    public Circle(double radius, String colour) {
        this.radius = radius;
        this.colour = colour;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String getType() {
        return "Circle";
    }

    public String getColour() {
        return colour;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    public String toString() {
        return this.toStringImpl();
    }
}
