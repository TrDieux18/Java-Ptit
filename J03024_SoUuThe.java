import java.util.Scanner;

public class J03024_SoUuThe {
    public static boolean Check(String s) {
        if (s.charAt(0) == '0')
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean Check2(String s) {
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') % 2 == 0) {
                cnt1++;
            } else {
                cnt2++;
            }
        }
        if(cnt1 == s.length() - 1 || cnt2 == s.length() - 1) return false;
        if (s.length() % 2 == 0) {
            return cnt1 > cnt2;
        } else {
            return cnt2 > cnt1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            if (!Check(s)) {
                System.out.println("INVALID");
            } else {
                if (Check2(s)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
}