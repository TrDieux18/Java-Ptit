
import java.util.Scanner;

public class J02014_DiemCanBang {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            long sum = 0, left = 0;
            int pos = 0;
            for(int i = 0; i < n; i++) sum += a[i];
            boolean ok = false;
            for(int i = 0; i < n; i++){
                sum -= a[i];
                if(sum == left){
                    pos = i;
                    ok  = true;
                    break;
                }
                left += a[i];
            }
            if(ok == false) System.out.println("-1");
            else System.out.println(pos+1);
        }
    }
} 