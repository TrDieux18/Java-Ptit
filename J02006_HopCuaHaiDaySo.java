// package BaiTest;
import java.util.Scanner;
import java.util.TreeSet;

public class J02006_HopCuaHaiDaySo {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n], b = new int[m];
        TreeSet<Integer> se = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            se.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            se.add(b[i]);
        }
        for(int i : se){
            System.out.print(i + " ");
        }
    }
}