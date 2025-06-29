// package BaiTest;
import java.util.Scanner;
// import java.lang.NoClassDefFoundError;

public class J01002_Tinh_tong_tu_1_den_n {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long sum = (n*(n+1))/2;
            System.out.println(sum);            
        }
        sc.close();
    }
}
