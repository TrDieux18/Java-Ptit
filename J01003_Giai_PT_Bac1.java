// package BaiTest;
import java.util.Scanner;

public class J01003_Giai_PT_Bac1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble(), b = sc.nextDouble();
        if(a == 000D){
            if(b == 000D)
                System.out.println("VSN");
            else System.out.println("VN");
        }
        else{
            System.out.println(String.format("%.2f", -b/a));
        }
        sc.close();
    }       
}