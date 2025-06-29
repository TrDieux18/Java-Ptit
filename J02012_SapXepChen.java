import java.util.Scanner;

public class J02012_SapXepChen{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = sc.nextInt();
        for(int i = 0; i < n; i++){
            int j = i;
            while(j > 0 && a[j] < a[j-1] ){
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
                j--;
            }
            System.out.print("Buoc "+ i+ ": ");
            for(int x = 0;  x <= i; x++){
                System.out.print(a[x]+ " ");
            }
            System.out.println();
        }
    }
}