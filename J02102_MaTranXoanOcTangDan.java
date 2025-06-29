import java.util.Scanner;
import java.util.Arrays;

public class J02102_MaTranXoanOcTangDan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n * n];
        for(int i = 0; i < n * n; i++) {
            a[i] = sc.nextInt();
        } 
        Arrays.sort(a); 
        int[][] ans = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int index = 0;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = a[index++];
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                ans[i][right] = a[index++];
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans[bottom][i] = a[index++];
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = a[index++];
                }
                left++;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
