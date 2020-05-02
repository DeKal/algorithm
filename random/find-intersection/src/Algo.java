import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Algo {
    static List<Point> line1 = new ArrayList<>(
            Arrays.asList(
                    new Point(0, 1),
                    new Point(1, 2),
                    new Point(2, 3),
                    new Point(3, 2),
                    new Point(4, 1),
                    new Point(5, 2),
                    new Point(6, 3)
            )
    );

    static List<Point> line2 = new ArrayList<>(
            Arrays.asList(
                    new Point(0, 0),
                    new Point(2, 2),
                    new Point(4, 4),
                    new Point(5, 1)
            )
    );

    public static void main(String[] args) {
        List<Point> line1 = sortLineByXAxis(Algo.line1);
        List<Point> line2 = sortLineByXAxis(Algo.line2);

        int pointerIndex1 = 0;
        int pointerIndex2 = 0;

        while (pointerIndex1 < line1.size() - 1
                && pointerIndex2 < line2.size() - 1) {
            Point point1FromLine1 = line1.get(pointerIndex1);
            Point point2FromLine1 = line1.get(pointerIndex1 + 1);
            Point point1FromLine2 = line2.get(pointerIndex2);
            Point point2FromLine2 = line2.get(pointerIndex2 + 1);
            boolean isIntersect = isIntersect(
                    point1FromLine1, point2FromLine1, point1FromLine2, point2FromLine2);

            if (isIntersect) {
                printIntersect(
                        point1FromLine1, point2FromLine1, point1FromLine2, point2FromLine2);
            }
            // Moving up to next line fragment
            if (isLesserOnXAxis(point2FromLine1, point2FromLine2)) {
                pointerIndex1++;
            } else {
                pointerIndex2++;
            }
        }
    }

    private static boolean isLesserOnXAxis(Point point2FromLine1, Point point2FromLine2) {
        return point2FromLine1.x < point2FromLine2.x;
    }


    static List<Point> sortLineByXAxis(List<Point> line) {
        line.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.x > p2.x) {
                    return 1;
                } else if (p1.x < p2.x) {
                    return -1;
                }
                return 0;
            }
        });
        return line;
    }

    static boolean isIntersect(Point point1, Point point2, Point point3, Point point4) {
        Line2D line1 = new Line2D.Float(point1, point2);
        Line2D line2 = new Line2D.Float(point3, point4);
        return line2.intersectsLine(line1);
    }

    private static void printIntersect(Point point1FromLine1, Point point2FromLine1, Point point1FromLine2, Point point2FromLine2) {
        System.out.println("Intersect found at:");
        System.out.println("Line 1:");
        System.out.println(point1FromLine1);
        System.out.println(point2FromLine1);

        System.out.println("Line 2:");
        System.out.println(point1FromLine2);
        System.out.println(point2FromLine2);

        System.out.println("Intersect at:");
        Point2D intersectPoint = intersect(
                point1FromLine1, point2FromLine1, point1FromLine2, point2FromLine2);
        System.out.println(intersectPoint);
    }

    // Idea getting from https://www.geeksforgeeks.org/program-for-point-of-intersection-of-two-lines/
    private static Point2D intersect(Point A, Point B, Point C, Point D) {
        // Line AB represented as a1x + b1y = c1
        double a1 = B.y - A.y;
        double b1 = A.x - B.x;
        double c1 = a1 * (A.x) + b1 * (A.y);

        // Line CD represented as a2x + b2y = c2
        double a2 = D.y - C.y;
        double b2 = C.x - D.x;
        double c2 = a2 * (C.x) + b2 * (C.y);

        double determinant = a1 * b2 - a2 * b1;


        double x = (b2 * c1 - b1 * c2) / determinant;
        double y = (a1 * c2 - a2 * c1) / determinant;
        return new Point2D.Double(x, y);

    }
}
