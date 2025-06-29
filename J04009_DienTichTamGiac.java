import java.util.Scanner;

class point {

    public double x, y;

    public point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(point B) {
        return Math.sqrt((this.x - B.x) * (this.x - B.x) + (this.y - B.y) * (this.y - B.y));
    }
}

public class J04009_DienTichTamGiac {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            point[] m = new point[3];
            for (int i = 0; i < 3; i++) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                m[i] = new point(x, y);
            }

            double a = m[0].distance(m[1]);
            double b = m[1].distance(m[2]);
            double c = m[0].distance(m[2]);

            if (a + b > c && b + c > a && a + c > b) {
                double S = 1 / 4f * Math.sqrt((a + b + c) * (a + b - c) * (-a + b + c) * (a - b + c));
                System.out.printf("%.2f\n", S);
                
            } else {
                System.out.println("INVALID");
            }
        }
        sc.close();
    }
}