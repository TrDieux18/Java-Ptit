import java.util.Scanner;
import java.util.Arrays;
public class J01025_HinhVuong {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] a = new int[4];
        int[] b = new int[4];
        for(int i = 0; i < 4; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
       
        int max1 = Math.max(a[3] - a[0], b[3] - b[0]);
        System.out.println(max1*max1);

    }
}