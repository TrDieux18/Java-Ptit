import java.util.Scanner;

public class J03013_HieuSoNguyenLon {
    public static Scanner sc = new Scanner(System.in);

    public static void Reverse(int a[], int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }

    public static void Sub(String s, String s1) {
        int n1 = s.length(), n2 = s1.length(), n = 0;
        int[] x = new int[n1];
        int[] y = new int[n1];
        int[] z = new int[n1];
        for (int i = 0; i < n1; i++)
            x[i] = (s.charAt(i) - '0');
        for (int i = 0; i < n2; i++)
            y[i] = (s1.charAt(i) - '0');
        Reverse(x, n1);
        Reverse(y, n2);
        for (int i = n2; i < n1; i++)
            y[i] = 0;
        int idx = 0;
        for (int i = 0; i < n1; i++) {
            int temp = x[i] - y[i] - idx;
            if (temp < 0) {
                idx = 1;
                z[n++] = 10 + temp;
            } else {
                z[n++] = temp;
                idx = 0;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(z[i]);
        }
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.next();
            String s1 = sc.next();
            if (s.length() > s1.length() || s.length() == s1.length()) {
                Sub(s, s1);
            } else
                Sub(s1, s);
            System.out.println();
        }
    }
}