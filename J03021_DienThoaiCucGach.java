import java.util.Scanner;

public class J03021_DienThoaiCucGach {

    public static char ChangeToDigit(char c) {
        if (c >= 'A' && c <= 'C')
            return '2';
        if (c >= 'D' && c <= 'F')
            return '3';
        if (c >= 'G' && c <= 'I')
            return '4';
        if (c >= 'J' && c <= 'L')
            return '5';
        if (c >= 'M' && c <= 'O')
            return '6';
        if (c >= 'P' && c <= 'S')
            return '7';
        if (c >= 'T' && c <= 'V')
            return '8';
        if (c >= 'W' && c <= 'Z')
            return '9';
        return '0';
    }

    public static boolean Check(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine().toUpperCase();
            String ans = "";
            for (int i = 0; i < s.length(); i++) {
                ans += ChangeToDigit(s.charAt(i));
            }
            if (Check(ans)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
