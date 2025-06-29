import java.util.Scanner;

// public  Scanner sc = new Scanner(System.in);
class Point1 {
    private double x;
    private double y;

    public Point1() {

    }

    public Point1(double x1, double y1) {
        this.x = x1;
        this.y = y1;
    }

    public Point1(Point1 p) {
        this.x = p.x;
        this.y = p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    double distance(Point1 p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    double distance(Point1 a, Point1 b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

};

public class J04008_ChuViTamGiac {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            Point1[] a = new Point1[3];
            for (int i = 0; i < a.length; i++) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                a[i] = new Point1(x, y);
            }
            double x = a[0].distance(a[1]);
            double y = a[1].distance(a[2]);
            double z = a[0].distance(a[2]);
            if(x + y > z && y + z > x && x + z > y){
                System.out.printf("%.3f ", x + y + z);
            }
            else{
                System.out.print("INVALID");
            }
            System.out.println();
        }
    }
}