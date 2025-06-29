import java.util.Scanner;

public class J02021_LietKeToHop_2 {
    public static Scanner sc = new Scanner(System.in);
    public static int n, k;
    public static int[] a = new int[21];
    public static void lietKe(){
        for(int i = 1; i <= k; i++){
            a[i] = i;
        }
        int cnt = 0;
        while(true){
            for(int i = 1; i <= k; i++){
                System.out.print(a[i]);
            }
            System.out.print(" ");
            ++cnt;
            int i = k;
            while(a[i] == n - k + i && i > 0) i--;
            if(i == 0) break;
            else{
                a[i]++;
                for(int j = i+1; j <= k; j++){
                    a[j] = a[j-1] + 1;
                }
            }
        }
        System.out.println();
        System.out.println("Tong cong co " + cnt + " to hop");
    }
    public static void main(String[] args) {
        n = sc.nextInt();
        k = sc.nextInt();
        lietKe();
    }
}