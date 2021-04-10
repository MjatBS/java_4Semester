import java.util.Objects;
import static java.lang.Math.*;
public class LineSegment {
    private Point first;
    private Point second;
    private String color;

    private double distance;

    LineSegment(){}
    LineSegment(Point first, Point second){
        setLocation(first,second);
    }

    public Point getFirst() {
        return first;
    }

    public Point getSecond() {
        return second;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLocation(Point first, Point second){
        this.first=first;
        this.second=second;
        calculateDistance();
    }

    private void calculateDistance(){
        distance = sqrt(pow(second.x()-first.x(),2) + pow(second.y()-first.y(),2));
    }

    public void scaleByPercent(double percent){
        if(percent>0){
            double difX = second.x() - first.x();
            double difY = second.y() - first.y();
            second.setLocation(first.x() + difX*percent, first.y() + difY*percent);
        }
    }

    public void rotate(double angle){
        double angleA = getAngle();
        double newAngle = angleA + angle;
        second = calculatePoint(newAngle);
    }
    double getAngle(){
        if(distance!=0) {
            double cosA = ((second.x() - first.x()) / distance);
            double sinA = ((second.y() - first.y()) / distance);
            double angleAsSin = asin(sinA), angleAsCos = acos(cosA);
            double angleA;
            if (angleAsSin >= 0) {
                angleA = angleAsCos;
            } else {
                angleA = PI + (PI - angleAsCos);
            }
            return angleA;
        }else return 0;
    }
    private Point calculatePoint(double angle){
        Point result;
        double difX = distance * cos(angle);
        double difY = distance * sin(angle);
        result = new Point(difX + first.x(), difY+first.y());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineSegment that = (LineSegment) o;
        return (Objects.equals(first, that.first) && Objects.equals(second, that.second))
                || (Objects.equals(first, that.second) && Objects.equals(second, that.first));
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "["+first.toString()+","+second+"]";
    }
}
