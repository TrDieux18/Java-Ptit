import java.util.Scanner;

import java.util.Arrays;

public class J02026_DayConCoKPhanTuTangDan {

    public static int n, k;
    public static int[] a, b;
    public static StringBuilder res;

    public static void out() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (b[i] == 1) {
                s.append(a[i]).append(" ");
            }
        }
        res.append(s.toString().trim()).append("\n");
    }

    public static void Try(int idx, int cnt) {
        if (cnt == k) {
            out();
            return;
        }

        for (int i = idx; i < n; i++) {
            b[i] = 1;
            Try(i + 1, cnt + 1);
            b[i] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);

            b = new int[n];
            res = new StringBuilder();
            Try(0, 0);
            System.out.print(res.toString());
        }
        sc.close();
    }
}
