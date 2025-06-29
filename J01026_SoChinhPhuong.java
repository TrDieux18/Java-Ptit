// package BaiTest;
import java.util.Scanner;

public class J01026_SoChinhPhuong {
    public static Scanner sc = new Scanner(System.in);
    public static boolean check(int n){
        int can = (int) Math.sqrt(n);
        if(can * can != n){
            return false;
        }
        else return true;
    }
    public static void main(String[] args) {
        int t =  sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            if(check(n)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}