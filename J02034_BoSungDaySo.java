import java.util.Scanner;

public class J02034_BoSungDaySo {
    public static Scanner sc =  new Scanner(System.in);
    public static int[] cnt = new int[201];
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a =  new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            if(a[i] > 0) cnt[a[i]]++;
        }
        int max1 = -1;
        for(int i = 0; i < n; i++){
            if(a[i] > max1){
                max1 = a[i];
            }
        }
        boolean ok = false;
        for(int i = 1; i <= max1; i++){
            if( cnt[i] == 0 ){
                System.out.println(i);
                ok = true;
            }
        }
        if(ok == false){
            System.out.println("Excellent!");
        }
    }
}