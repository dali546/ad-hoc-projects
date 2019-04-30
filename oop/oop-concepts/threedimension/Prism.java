package threedimension;

import interfaces.ThreeDimensionalShape;
import interfaces.TwoDimensionalShape;

public class Prism implements ThreeDimensionalShape {

    private TwoDimensionalShape base;
    private double depth;

    public Prism(TwoDimensionalShape base, double depth) {
        this.base = base;
        this.depth = depth;
    }

    public double getVolume() {
        return base.getArea() * depth;
    }

    public double getSurfaceArea() {
        return (base.getArea() * 2) + (depth * base.getPerimeter());
    }

    public String toString() {
        return this.toStringImpl();
    }

    public String getType() {
        return "Prism";
    }

    public String getColour() {
        return base.getColour();
    }
}
