import java.io.Serializable;

public class Cube extends GeomObjects  {
    private double a;

    public Cube(double a) {
        this.a = a;
    }

    @Override
    public double volume() {
        return Math.pow(a, 3);
    }

    @Override
    public double surfaceArea() {
        return 6 * Math.pow(a, 2);
    }

    public double getParams() {
        return a;
    }
}