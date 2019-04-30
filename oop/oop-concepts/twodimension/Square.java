package twodimension;

public class Square extends Rectangle {

    public Square(double width, String colour) {
        super(width, width, colour);
    }

    @Override
    public String getType() {
        return "Square";
    }
}
