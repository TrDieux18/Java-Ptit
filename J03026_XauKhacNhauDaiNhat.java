import java.util.Scanner;

public class J03026_XauKhacNhauDaiNhat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        // sc.nextLine();
        while (t-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();
            // int n = s1.length(), m = s2.length();
            System.out.println(s1.equals(s2) ? -1 : Math.max(s1.length(), s2.length()));
        }
        sc.close();
    }
}