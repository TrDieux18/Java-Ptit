import java.math.BigInteger;
import java.util.Scanner;

public class J03015_HieuSoNguyenLon_2 {
    public static Scanner sc = new Scanner(System.in);

    public static void reverse(int[] a, int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }

    public static void sub(String s, String s1) {
        int n1 = s.length(), n2 = s1.length();
        int[] x = new int[n1];
        int[] y = new int[n1];
        int[] z = new int[n1];

       
        for (int i = 0; i < n1; i++) x[i] = (s.charAt(i) - '0');
        for (int i = 0; i < n2; i++) y[i] = (s1.charAt(i) - '0');

        
        reverse(x, n1);
        reverse(y, n2);

        
        for (int i = n2; i < n1; i++) y[i] = 0;

        int carry = 0;
        int n = 0;
        for (int i = 0; i < n1; i++) {
            int temp = x[i] - y[i] - carry;
            if (temp < 0) {
                carry = 1;
                z[n++] = 10 + temp;
            } else {
                z[n++] = temp;
                carry = 0;
            }
        }

        // Loại bỏ các chữ số 0 ở đầu
        int i = n - 1;
        while (i >= 0 && z[i] == 0) i--;

        if (i == -1) {
            System.out.println("0");
        } else {
            for (; i >= 0; i--) {
                System.out.print(z[i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // String s = sc.next();
        // String s1 = sc.next();

        // if (s.length() > s1.length() || (s.length() == s1.length() && s.compareTo(s1) >= 0)) {
        //     sub(s, s1);
        // } else {
        //     System.out.print("-");
        //     sub(s1, s);
        // }
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        System.out.println(a.subtract(b));
    }
}
