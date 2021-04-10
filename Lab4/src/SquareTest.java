import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
class SquareTest {
    Square squares[];
    Point[][] coordinates = {{new Point(0,0), new Point(1,0)},
                             {new Point(1,1), new Point(0,1)},
                             {new Point(0,0), new Point(-2,-4)},
                             {new Point(1,1), new Point(1,1)},
                             {new Point(5,7), new Point(10,8)}};
    SquareTest(){
        System.out.println("Initialization");
        squares = new Square[5];
        for(int i=0;i<squares.length;i++){
            squares[i] = new Square(coordinates[i][0], coordinates[i][1]);
            System.out.println(squares[i]);
        }
        System.out.println();
    }

    @Test
    void rotate() {
        System.out.println("Test rotate");
        double angle= Math.PI / 4;
        for(Square sq : squares){
            Square initial = sq;
            sq.rotate(angle);
            System.out.println(sq);
            sq.rotate(-angle);
            assertTrue(sq.equals(initial));
        }
        System.out.println();
    }

    @Test
    void compression() {
        System.out.println("Test compression");
        double percent = 0.5;
        for(Square sq : squares){
            Square initial = sq;
            sq.compression(percent);
            System.out.println(sq);
            sq.stretching(1/percent);
            assertTrue(sq.equals(initial));
        }
        System.out.println();
    }

    @Test
    void stretching() {
        System.out.println("Test stretching");
        double scale = 3;
        for(Square sq : squares){
            Square initial = sq;
            sq.stretching(scale);
            System.out.println(sq);
            sq.compression(1/scale);
            assertTrue(sq.equals(initial));
        }
        System.out.println();
    }
}