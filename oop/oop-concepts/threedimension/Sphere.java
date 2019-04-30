package threedimension;

import interfaces.ThreeDimensionalShape;

public class Sphere implements ThreeDimensionalShape {

    private double radius;
    private String colour;

    public Sphere(double radius, String colour) {
        this.radius = radius;
        this.colour = colour;
    }

    public double getVolume() {
        return 4 * Math.PI * radius * radius * radius / 3;
    }

    public double getSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    public String getType() {
        return "Sphere";
    }

    public String getColour() {
        return colour;
    }

    public String toString() {
        return toStringImpl();
    }
}
