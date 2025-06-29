
import java.util.Scanner;

class POINT {

    private double x, y;

    public POINT(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static POINT nextPOINT(Scanner sc) {
        return new POINT(sc.nextDouble(), sc.nextDouble());
    }

}

class Triangle {

    private POINT a, b, c;

    public Triangle(POINT a, POINT b, POINT c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean valid(){
        double ab = Math.sqrt((b.getX() - a.getX()) * (b.getX() - a.getX()) + (b.getY() - a.getY())*(b.getY() - a.getY()));
        double cb = Math.sqrt((c.getX() - b.getX()) * (c.getX() - b.getX()) + (c.getY() - b.getY())*(c.getY() - b.getY()));
        double ca = Math.sqrt((a.getX() - c.getX()) * (a.getX() - c.getX()) + (a.getY() - c.getY())*(a.getY() - c.getY()));
        if(ab +  cb > ca && cb + ca > ab && ab + ca > cb){
            return true;
        }
        return false;
    }

    public String getPerimeter(){
        double ab = Math.sqrt((b.getX() - a.getX()) * (b.getX() - a.getX()) + (b.getY() - a.getY())*(b.getY() - a.getY()));
        double cb = Math.sqrt((c.getX() - b.getX()) * (c.getX() - b.getX()) + (c.getY() - b.getY())*(c.getY() - b.getY()));
        double ca = Math.sqrt((a.getX() - c.getX()) * (a.getX() - c.getX()) + (a.getY() - c.getY())*(a.getY() - c.getY()));
        return String.format("%.3f", ab + cb + ca);
    }

}

public class J04019_LopTriangle1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            Triangle a = new Triangle(POINT.nextPOINT(sc), POINT.nextPOINT(sc), POINT.nextPOINT(sc));
            if (!a.valid()) {
                System.out.println("INVALID");
            } else {
                System.out.println(a.getPerimeter());
            }
        }
    }
}