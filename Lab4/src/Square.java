import java.util.Arrays;

public class Square {
    private LineSegment[] sides;
    public Square(Point first, Point second){
        init();
        generateSquare(first, second);
    }
    private void init(){
        sides = new LineSegment[4];
        for( int i=0;i<4;i++){
            sides[i] = new LineSegment();
        }
    }
    /**
     *
     * @param first
     * @param second
     * create square by vector (first, second) in the counterclockwise direction
     */
    private void generateSquare(Point first, Point second){
        sides[0].setLocation(first, second);
        Point third = getNextGeneratedPoint(first,second);
        Point fourth = getNextGeneratedPoint(second, third);
        sides[1].setLocation(second, third);
        sides[2].setLocation(third, fourth);
        sides[3].setLocation(fourth, first);
    }
    private void generateSquare(LineSegment segment){
        generateSquare(segment.getFirst(), segment.getSecond());
    }
        private Point getNextGeneratedPoint(Point first, Point second){
            double nextX = second.x() + (first.y() - second.y());
            double nextY = second.y() - (first.x() - second.x());
            return new Point(nextX, nextY);
        }

    /**
     *
     * @param angle in radians
     */
    public void rotate(double angle){
        sides[0].rotate(angle);
        generateSquare(sides[0]);
    }

    /**
     *
     * @param percent 0 < percent < 1
     * @return success
     */
    public boolean compression(double percent){
        if(percent>0 && percent <1) {
            sides[0].scaleByPercent(percent);
            generateSquare(sides[0]);
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @param scale scale >= 1
     * @return success of operation
     */
    public boolean stretching(double scale){
        if(scale >= 1) {
            sides[0].scaleByPercent(scale);
            generateSquare(sides[0]);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Square" + Arrays.toString(sides);
    }
}
