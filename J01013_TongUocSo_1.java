// package BaiTest;
import java.util.Scanner;



public class J01013_TongUocSo_1 {
    public static Scanner sc = new Scanner(System.in);
    public static final int MOD = (int) 2e6;
    public static int[] Prime = new int[MOD + 5];

    public static void Sang_NT(){
        Prime[0] = Prime[1] = 0;
        for(int i = 2; i <= MOD; i++){
            Prime[i] = 1;
        }
        for(int i = 2; i <= Math.sqrt(MOD); i++){
            if(Prime[i] == 1){
                for(int j = i*i; j <= MOD; j += i){
                    if(Prime[j] == 1){
                        Prime[j] = i;
                    }
                }
            }
        }
        for(int i = 2; i <= MOD; i++){
            if(Prime[i] == 1){
                Prime[i] = i;
            }
        }
    }

    public static int Sum(int n){
        if(Prime[n] == 1){
            return n;
        }
        int tong = 0;
        while( n != 1){
            tong += Prime[n];
            n /= Prime[n];
        }
        return tong;
    }
    public static void main(String[] args) {
        Sang_NT();
        int t =  sc.nextInt();
        long sum_1 = 0;
        for(int i = 0; i < t; i++){
            int x = sc.nextInt();
            sum_1 += Sum(x);
        }
        System.out.println(sum_1);
    }
}