
import java.util.Scanner;


public class J01021_TinhLuyThua {
    public static long MOD =  1000000000+7;
    public static Scanner sc = new Scanner(System.in);
    static long a, b;
    public static void nhap(){
        a = sc.nextLong();
        b = sc.nextLong();
    }
    public static long pow(long a, long b){
        long tich  = 1;
        
        if(b == 0) return 1;
        while( b != 0){
            if(b % 2 != 0){
                tich = ((tich % MOD)*(a % MOD)) % MOD;
            }
            b /= 2;
            a  = a %MOD * a %MOD;
        }
        return tich % MOD;
    }
    public static void main(String[] args) {
        while(true){
            nhap();
            if(a == 0 && b == 0 ) break;
            System.out.println(pow(a, b));
        }
    }   
}