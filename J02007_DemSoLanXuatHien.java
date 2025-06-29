// package BaiTest;

import java.util.Scanner;
// import java.util.Arrays;
// import java.util.TreeMap;

public class J02007_DemSoLanXuatHien {
    public static Scanner sc = new Scanner(System.in);
    public static int[] cnt = new int[100001];
    public static void main(String[] args) {
        int t =  sc.nextInt();
        for(int x = 1; x <= t; x++){
            
            int n = sc.nextInt();
            int[] a = new int[n];
            // TreeMap<Integer,Integer> mp = new TreeMap<>();
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
                cnt[a[i]]++;
            }
            System.out.println("Test "+ x + ":" );
            for(int i = 0; i < n ; i++){
                if(cnt[a[i]] > 0){
                    System.out.println(a[i] + " xuat hien " +  cnt[a[i]]  + " lan");
                }
                cnt[a[i]] = 0;
            }
        }
    }
}

