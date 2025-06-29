import java.util.Scanner;

class DaGiac {
    int x, y;

    public DaGiac(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class J05008_DienTichGiac {

    public static double Area(DaGiac[] a, int n) {
        double area = 0;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n; // chi so vong quanh
            // System.out.println("Ket qua (i + 1) % n: "+j);
            area += a[i].x * a[j].y;
            area -= a[j].x * a[i].y;
        }
        return Math.abs(area) / 2.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            DaGiac[] a = new DaGiac[n];

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                a[i] = new DaGiac(x, y);
            }

            double area = Area(a, n);

            System.out.printf("%.3f\n", area);
        }
        sc.close();
    }
}
