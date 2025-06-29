import java.util.Scanner;
import java.math.BigInteger;
public class J03011_UCLNcuaSoNguyenLon {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0){
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            System.out.println(a.gcd(b));
        }
    }
}
