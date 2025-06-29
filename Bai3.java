import java.util.Scanner;
public class Bai3 {

    public static boolean Checknt(int n){
        if(n < 2) return false;
        for(int i = 2; i <=Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =  sc.nextInt();
        for(int x = 1; x <= t; x++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] a = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    a[i][j] = sc.nextInt();
                }
            }
            System.out.printf("Test %d:", x);
            System.out.println();
            for(int i = 0; i < n; i++){
                boolean ok = true;
                for(int j = 0; j < m; j++){
                    if(!Checknt(a[i][j])){
                        ok = false;
                        break;
                    }
                }
               if(ok) System.out.print(i + " ");
            }
        }
        sc.close();
    }
}