// package BaiTest;

import java.util.Scanner;

public class J01010_CatDoi {
    public static Scanner sc = new Scanner(System.in);

    public static void outra() {
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '8' || s.charAt(i) == '9') {
                if (s.charAt(i) == '8' || s.charAt(i) == '9') {
                    s = s.replace(s.charAt(i), '0');
                }
            } else {
                System.out.println("INVALID");
                return;
            }
        }
        int pos = 0;
        while (s.charAt(pos) == '0' && pos < s.length()-1) {
            pos++;
            // if(pos == s.length()-1) break;
        }
        if (pos == s.length()-1) {
            System.out.print("INVALID");
        } else {
            System.out.print(s.substring(pos));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0){
            outra();
        }
    }
}