import static java.lang.Math.PI;

public class Sphere extends Shape{

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double Volume() {
        return ((4*PI*radius*radius*radius)/3);
    }
}