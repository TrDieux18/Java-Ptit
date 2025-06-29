// package BaiTest;
import java.util.Scanner;

public class J01009_TongGiaiThua {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n  = sc.nextLong();
		 long res = 0, temp = 1;
		for(int i = 1; i <= n; i++){
			temp *=i;
			res += temp;
		}
		System.out.println(res);
        sc.close();
    }
    
}