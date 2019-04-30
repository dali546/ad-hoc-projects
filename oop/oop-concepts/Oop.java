import threedimension.Cube;
import threedimension.Prism;
import threedimension.Sphere;
import twodimension.Circle;
import twodimension.Rectangle;
import twodimension.Square;

public class Oop {

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(25.0, 15.0, "Red");
        Rectangle spongeBob = new Rectangle(50.0, 50, "Yellow");
        Circle moon = new Circle(35, "White");
        Circle sun = new Circle(125, "Yellow");
        Square doodleBob = new Square(50, "Grey");
        Prism prism = new Prism(spongeBob, 20);
        Sphere ball = new Sphere(75, "Black");
        Cube cube = new Cube(new Square(5,"Green"));


        System.out.println(rectangle1);
        System.out.println(spongeBob);
        System.out.println(sun);
        System.out.println(moon);
        System.out.println(doodleBob);
        System.out.println(prism);
        System.out.println(ball);
        System.out.println(cube);

    }
}