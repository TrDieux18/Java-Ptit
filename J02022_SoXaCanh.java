import java.util.Scanner;
// import java.util.Arrays;

public class J02022_SoXaCanh {
    // public static boolean Check1(int n) {
    // // int sum = 0;
    // while (n != 0) {
    // if (n % 10 == 0) {
    // return false;
    // }
    // n /= 10;
    // }
    // return true;
    // }

    // public static boolean Check2(int n, int k) {
    // boolean[] cnt = new boolean[k + 1];
    // Arrays.fill(cnt, false);
    // while (n != 0) {
    // int so = n % 10;
    // if (so > k || cnt[so] == true) {
    // return false;
    // }
    // cnt[so] = true;
    // n /= 10;
    // }
    // for (int i = 1; i <= k; i++) {
    // if (cnt[i] == false) {
    // return false;
    // }
    // }
    // return true;
    // }

    // public static boolean Check3(int n) {
    // String s = String.valueOf(n);
    // for (int i = 0; i < s.length() - 1; i++) {
    // if (Math.abs((s.charAt(i) - '0') - (s.charAt(i + 1) - '0')) == 1) {
    // return false;
    // }
    // }
    // return true;
    // }

    public static int n;
    public static boolean[] Check;
    public static int[] a;

    public static void out() {
        for (int i = 1; i < n; i++) {
            if (Math.abs(a[i] - a[i + 1]) == 1) {
                return;
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void Try(int i) {
        for (int j = 1; j <= n; j++) {
            if (Check[j] == false) {
                Check[j] = true;
                a[i] = j;
                if (i == n)
                    out();
                else
                    Try(i + 1);
                Check[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            // boolean ok = false;
            // for (int i = (int) Math.pow(10, n - 1); i < (int) Math.pow(10, n); i++) {
            // if (Check2(i, n) && Check3(i)) {
            // System.out.printf(i + " ");
            // ok = true;
            // }
            // }
            // if (ok == false)
            // System.out.print(" ");
            // System.out.println();
            a = new int[n + 1];
            Check = new boolean[n + 1];
            Try(1);
        }
        sc.close();
    }
}
