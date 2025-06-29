// package BaiTest;
import java.util.Scanner;

public class J01014_UocSoNguyenToLonNhat {
    public static Scanner sc = new Scanner(System.in);
    public static void Print_1(){
        long n = sc.nextLong();
        long[] a = new long[101];
        int cnt = 0;
        for(int i = 2; i <= Math.sqrt(n); i++){
            while(n % i == 0){
                a[cnt++] += i;
                n /= i;
            }
        }
        if(n != 1){
            a[cnt++] = n;
        }
        System.out.println(a[cnt-1]);
    }
    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0){
            Print_1();
        }
    }
}