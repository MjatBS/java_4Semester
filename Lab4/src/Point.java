import java.util.Objects;

public class Point {
    private double x;
    private double y;
    Point(double x, double y){
        setLocation(x, y);
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public void setLocation(double x, double y){
        this.x=x;
        this.y=y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "("+String.format("%.2f",x)+","+String.format("%.2f",y)+")";
    }
}
