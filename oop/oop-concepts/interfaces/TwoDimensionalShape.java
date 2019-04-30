package interfaces;

public interface TwoDimensionalShape extends Shape {

    double getArea();

    double getPerimeter();

    default String toStringImpl() {
        return "A " + getColour() + " " + getType() + " with Perimeter " + getPerimeter() + " and Area " + getArea();
    }

}
