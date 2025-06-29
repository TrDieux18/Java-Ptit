
import java.util.Scanner;

public class J02008_BoiSoNhoNhatCuaNSoNguyenDuongDauTien {
    public static Scanner sc = new Scanner(System.in);
    public static long gcd(long a, long b){
        if( b == 0) return a;
        else return gcd(b, a%b);
    }
    public static long lcm(long a, long b){
        return a*b/ gcd(a, b);
    }
    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long res = 1;
            for(long i = 1; i <= n; i++){
                res = lcm(res, i);
            }
            System.out.println(res);
        }    
    }
}


