import java.util.Scanner;

public class J02011_SapXepChon {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int min1 = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min1]) {
                    min1 = j;
                }
            }
            int temp = a[i];
            a[i] = a[min1];
            a[min1] = temp;
            System.out.print("Buoc " + (i + 1) + ": ");
            for (int j = 0; j < n; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
    }
}