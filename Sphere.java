import java.io.Serializable;

public class Sphere extends GeomObjects{
    private double r;

    public Sphere(double r) {
        this.r = r;
    }

    @Override
    public double volume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
    }

    @Override
    public double surfaceArea() {
        return 4 * Math.PI * Math.pow(r, 2);
    }

    public double getParams() {
        return r;
    }
}
