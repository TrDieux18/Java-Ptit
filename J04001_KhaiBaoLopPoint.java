import java.util.Scanner;

// public  Scanner sc = new Scanner(System.in);
class Point {
    private double x;
    private double y;

    public Point() {

    }

    public Point(double x1, double y1) {
        this.x = x1;
        this.y = y1;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    double distance(Point p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
}

public class J04001_KhaiBaoLopPoint {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            Point a = new Point(x1, y1);
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            Point b = new Point(x2, y2);
            System.out.printf("%.4f", a.distance(b));
            System.out.println();
        }
    }
}