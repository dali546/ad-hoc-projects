package interfaces;

public interface ThreeDimensionalShape extends Shape {

    double getVolume();
    double getSurfaceArea();

    default String toStringImpl() {
        return "A " + getColour() + " " + getType() + " with Surface Area " + getSurfaceArea() + " and Volume " + getVolume();
    }
}
