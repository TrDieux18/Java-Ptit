import java.util.Scanner;

public class J1005_ChiaTamGiac{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0 ){
            double n = sc.nextDouble();
            double h = sc.nextDouble();
            for(int i = 1; i < n; i++){
                System.out.printf("%.6f ", h * Math.sqrt(i/n));
            }
            System.out.println();
        }
    }
}