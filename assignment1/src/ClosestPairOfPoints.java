import java.awt.*;


public class ClosestPairOfPoints {
    class Points{
        float x, y;
        public Points(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Point[] points = {
                new Point(2, 3),
                new Point(12, 30),
                new Point(40, 50),
                new Point(5, 1),
                new Point(12, 10),
                new Point(3, 4)
        };

        System.out.println("The smallest is: " + closest(points));
    }
    private static float dist(Point a, Point b){ // cal distance between two points
        return (float) Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y)); // distance formula
    }
    public static double closest(Point[] points) { // finds the smallest distance
        double min = Double.POSITIVE_INFINITY; // starts with highest value to be compared with others
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double d = dist(points[i], points[j]);
                // after cal replaces the highest value
                if (d < min) min = d;
            }
        }
        return min;
    }
}
