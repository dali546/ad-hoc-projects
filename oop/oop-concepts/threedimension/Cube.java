package threedimension;

import twodimension.Square;

public class Cube extends Cuboid {

    public Cube(Square base) {
        super(base, base.getWidth());
    }
}
