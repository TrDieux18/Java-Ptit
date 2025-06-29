import java.util.Scanner;

public class J02104_DanhSachCanh {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = sc.nextInt(); 
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[i][j] == 1 && i < j){
                    System.out.printf("(%d,%d)", i+1,j+1);
                    System.out.println();
                }
            }
            
        }
    }
}