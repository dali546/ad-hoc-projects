package twodimension;

import interfaces.Shape;
import interfaces.TwoDimensionalShape;

public class Rectangle implements TwoDimensionalShape, Shape {

    private double width, height;
    private String colour;

    public Rectangle(double width, double height, String colour) {
        this.width = width;
        this.height = height;
        this.colour = colour;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getType() {
        return "Rectangle";
    }

    public String getColour() {
        return colour;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return width + width + height + height;
    }

    public String toString() {
        return this.toStringImpl();
    }
}
