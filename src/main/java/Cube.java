public class Cube extends Shape {

    private double edgeLenght;

    public double getEdgeLenght() {
        return edgeLenght;
    }

    public void setEdgeLenght(double edgeLenght) {
        this.edgeLenght = edgeLenght;
    }

    public Cube(double edgeLenght) {
        this.edgeLenght = edgeLenght;
    }

    @Override
    public double Volume() {
        return edgeLenght*edgeLenght*edgeLenght;
    }
}