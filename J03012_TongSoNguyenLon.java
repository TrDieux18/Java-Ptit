import java.util.Scanner;
import java.math.BigInteger;

public class J03012_TongSoNguyenLon {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            System.out.println(a.add(b));
        }
        sc.close();
    }
}




