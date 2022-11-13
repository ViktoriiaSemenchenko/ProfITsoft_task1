import static java.lang.Math.PI;

public class Cylinder extends Shape{


    private double radius;
    private double height;


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double Volume() {
        return (PI*radius*radius*height);
    }
}