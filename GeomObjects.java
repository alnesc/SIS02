import java.io.Serializable;

public abstract class GeomObjects implements Serializable {
    public abstract double volume();
    public abstract double surfaceArea();
    public abstract double getParams();
}