import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class J02025_DayConCoTongSoNguyenTo {

    public static int n;
    public static int[] a, b;
    public static List<String> res;

    public static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean SumPrime(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return isPrime(sum);
    }

    public static void out() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (b[i] == 1) {
                list.add(a[i]);
            }
        }

        if (SumPrime(list)) {
            StringBuilder s = new StringBuilder();
            for (Integer i : list) {
                s.append(i).append(" ");
            }
            res.add(s.toString().trim());
        }
    }

    public static void Try(int i) {
        for (int j = 0; j <= 1; j++) {
            b[i] = j;
            if (i == n - 1) {
                out();
            } else {
                Try(i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);
            for (int i = 0; i < n / 2; i++) {
                int temp = a[i];
                a[i] = a[n - i - 1];
                a[n - i - 1] = temp;
            }
            b = new int[n];
            res = new ArrayList<>();
            Try(0);

            for (String i : res) {
                System.out.println(i);
            }
        }
        sc.close();
    }
}
