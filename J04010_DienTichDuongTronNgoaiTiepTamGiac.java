import java.util.Scanner;

class POint {

    public double x, y;

    public POint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(POint B) {
        return Math.sqrt((x - B.x) * (x - B.x) + (y - B.y) * (y - B.y));
    }
}

public class J04010_DienTichDuongTronNgoaiTiepTamGiac {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            POint[] m = new POint[3];
            for (int i = 0; i < 3; i++) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                m[i] = new POint(x, y);
            }

            double a = m[0].distance(m[1]);
            double b = m[1].distance(m[2]);
            double c = m[0].distance(m[2]);

            if (a + b > c && b + c > a && a + c > b) {
                double S = 1 / 4f * Math.sqrt((a + b + c) * (a + b - c) * (-a + b + c) * (a - b + c));
                double R = a*b*c/(S*4);
                System.out.printf("%.3f\n", Math.PI * R* R);
                
            } else {
                System.out.println("INVALID");
            }
        }
        sc.close();
    }
}