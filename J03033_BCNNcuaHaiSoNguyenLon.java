import java.util.Scanner;
import java.math.BigInteger;
public class J03033_BCNNcuaHaiSoNguyenLon {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0){
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            BigInteger uc = a.gcd(b);
            BigInteger nhan = a.multiply(b);
            BigInteger lcm = nhan.divide(uc);
            System.out.println(lcm);
        }
    }
}