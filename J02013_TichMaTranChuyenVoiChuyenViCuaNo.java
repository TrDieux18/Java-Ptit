import java.util.Scanner;

public class J02013_TichMaTranChuyenVoiChuyenViCuaNo {
  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int t = sc.nextInt();
    for (int x = 1; x <= t; x++) {
      int n = sc.nextInt(), m = sc.nextInt();
      int[][] a = new int[n][m];
      int[][] b = new int[m][n];
      // int[][] c = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          a[i][j] = sc.nextInt();
          b[j][i] = a[i][j];
        }
      }
      System.out.println("Test " + x + ": ");
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          int sum = 0;
          for (int k = 0; k < m; k++) {
            sum += a[i][k] * b[k][j];
          }
          System.out.print(sum + " ");
        }
        System.out.println();
      }
    }
  }
}