// package BaiTest;
import java.util.Scanner;
public class J01008_PhanTichThuaSoNguyenTo {
    public static Scanner sc = new Scanner(System.in);

    // public static void Ptsnt() {
    // int n = sc.nextInt();
    // int buoc = 1;
    // System.out.print("Test " + buoc + ": ");
    // buoc++;
    // for (int i = 2; i <= Math.sqrt(n); i++) {
    // int cnt = 0;
    // while (n % i == 0) {
    // ++cnt;
    // n /= i;
    // }
    // if (cnt > 0) {
    // System.out.print(i + "(" + cnt + ") ");
    // }
    // }
    // if (n > 1) {
    // System.out.print(n + "(1)");
    // }
    // System.out.println();
    // }

    public static void main(String[] args) {
        int t = sc.nextInt();
        int b = 1;
        while(t-- > 0) {
            // Ptsnt();
            int n = sc.nextInt();
            System.out.print("Test "+ b +": ");
            b++;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                int cnt = 0;
                while (n % i == 0) {
                    ++cnt;
                    n /= i;
                }
                if (cnt > 0) {
                    System.out.print(i + "(" + cnt + ") ");
                }
            }
            if (n > 1) {
                System.out.print(n + "(1)");
            }
            System.out.println();
        }
        sc.close();
    }
}
