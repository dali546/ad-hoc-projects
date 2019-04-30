# Object-Oriented Programming Concepts

## Classes

You should hopefully already be familiar with the concept of a _class_! A class is the basic unit of a Java program - all of the code that you write will be inside a class.

In OOP, you consider classes to be a definition of a "type of thing" - if you'll excuse the vagueness! Each class has two types of content:

 - Data - the fields (variables) that are stored in the class
 - Behaviour - the methods defined on the class

Get started by writing some classes to represent the following objects:

 - A `Rectangle` class that stores the width, height and colour of the rectangle, has methods that retrieve those fields (getters) and also some methods to calculate its area and perimeter.

- A `Circle` class that stores the radius and colour of the circle, has methods that retrieve those fields, and also some methods to calculate its area and perimter.

## Instances

An _instance_ of a class is an actual "thing" - whereas the class itself was just a "type of thing". For example, the `Rectangle` class represents what it means to be a rectangle _in general_, but an _instance_ of `Rectangle` is a specific rectangle.

You create instances of a class using a _constructor_. Add a constructor to your two classes so far. What inputs does your constructor need?

Write a `main` method that constructs two different `Rectangle` instances and two different `Circle` instances, and then prints out some details about them to the console.

## Inheritance

One class can _inherit from_ or _extend_ another class. This means that the inheriting class (called a _subclass_ or _child class_) can have access to all the `public` or `protected` members of the _parent class_ or _superclass_.

Inheritance is often referred to as an "is-a" relationship - when class `B` inherits from class `A`, that is because class `B` is just a _more specific_ type of `A`.

Define a `Square` class that extends your `Rectangle` class - because a square is just a special case of a rectangle where the width and the height are equal.

`Square` should have its own constructor - one that just takes a single measurement and a colour - and then use `super(...)` to call the parent constructor. The other behaviour will be inherited from `Rectangle`.

## Interfaces

An interface is like a contract. An interface defines certain methods that a class _must_ implement, and any class that has those methods is said to _implement_ that interface.

There are some commonalities between your shape classes so far - they all have a colour, they all have a perimeter, and they all have an area. Define the following two interfaces:

```java
public interface Shape {
    String getType();
    String getColour();
}
```

```java
import interfaces.Shape;public interface TwoDimensionalShape extends Shape {
    double getPerimeter();
    double getArea();
}
```

Make your shape classes implement `TwoDimensionalShape`. What changes (if any!) did you need to make?

## Default methods

By now, if you've played around at all with your shape classes by writing code in `main`, you will probably have become annoyed that your shapes don't display nicely to the console by default:

`Square@25cd5fa`

It would be nice if all shapes automatically had a method that you could call to get a nice string form, even without us having to write one! This is possible using a _default method_ on the `TwoDimensionalShape` interface:

```java
public interface TwoDimensionalShape {
    //...
    default String prettyPrint() {
        return "A " + getColour() + " " + getType() + " with perimeter " + getPerimeter() + " and area " + getArea();
    }
}
```

Now anything that implements `TwoDimensionalShape` will automatically pick up a `prettyPrint()` implementation. Give it a try!

## Composition

Composition of classes is a term that refers to when the fields of one class are themselves instances of another class. Composition is often referred to as a "has-a" relationship, because if an instance of class `A` has an instance of class `B` as one of its fields, then it makes sense to say that the instance of `A` "contains" or "has" an instance of `B`.

Composition is the most common way that more complex classes are created from simple ones. For example, supposing you have an `Author` class, you can have a `Book` class that uses composition by having a field which is of type `Author`.

Or, suppose you have the following classes:

 - `Product` which represents a particular product, including its price
 - `Customer` which represent a particular customer of your business

Then you can compose these two classes to create `Invoice`, which needs to have details of both a product and a customer.

Adding to your collection of shape-related classes, define a `Prism` class. Remember that a prism is a 3D shape that has a 2D shape as a "base", and stretches that base up to a certain height (imagine a cuboid - rectangular base, or a cylinder - circular base).

The `Prism` constructor should take a `TwoDimensionalShape` base, and a height. Define the following interface:

```java
import interfaces.Shape;public interface ThreeDimensionalShape extends Shape {
    double getSurfaceArea();
    double getVolume();
    default String toString() { 
        //... 
    }
}
```

## Practice - More 3D shapes

Define a `Sphere` class. This will be another class that implements `ThreeDimensionalShape`, but this time, it isn't possible to build it up form our previous shapes using either composition or inheritance - it's a brand new type of shape. That's fine!

What properties do you need to define a sphere, and to make sure the `Sphere` class implements `ThreeDimensionalShape`?

## Practice - More inheritance

To get some more practice at using inheritance, define the following shapes, which are just more specific versions of shapes you already have:

 - `Cuboid` which extends `Prism`
 - `Cube` which extends `Cuboid`
 - `Cylinder` which extends `Prism`
