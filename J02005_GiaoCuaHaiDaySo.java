// package BaiTest;
import java.util.Scanner;
import java.util.TreeSet;

public class J02005_GiaoCuaHaiDaySo {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n], b = new int[m];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }
        TreeSet<Integer> hse = new TreeSet<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i] == b[j]){
                    hse.add(a[i]);
                }
            }
        }
        for(int i  : hse){
            System.out.print(i +  " ");
        }
        System.out.println();
    }
}