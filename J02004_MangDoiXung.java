// package BaiTest;
import java.util.Scanner;

public class J02004_MangDoiXung {
    public static Scanner sc = new Scanner(System.in);
    public static void in(int[] a, int n){
        int l = 0, r = n-1;
        while(l < r){
            if(a[l] != a[r]){
                System.out.println("NO");
                return;
            }
            l++; r--;
        }
        System.out.println("YES");
    }

    public static void main(String[] args) {
        int t =  sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            in(a, n);
        }
    }
}