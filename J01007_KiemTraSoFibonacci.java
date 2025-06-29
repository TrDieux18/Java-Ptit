// package BaiTest;
import java.util.Scanner;

public class J01007_KiemTraSoFibonacci {
    public static long[] F = new long[101];
    public static void fibo(){
        F[0] = 0L;
        F[1] = F[2] = 1L;
        for(int i = 3; i <= 93 ; i++){
            F[i] = F[i-1] + F[i-2];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        fibo();
        while(t-- > 0){
            long n = sc.nextLong();
            boolean ok = false;
            for(int i = 0; i <=93 ; i++){
                if(F[i] == n){
                    ok = true;
                    break;
                }
            }
            if(ok == true){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }        
        sc.close();
    }
}