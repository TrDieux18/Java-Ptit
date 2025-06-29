// package BaiTest;
import java.util.Scanner;

// import java.util.Vector;

public class J03004_ChuanHoaHoTen {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine().trim();
            String[] words = s.split("\\s+");
            for(int i = 0; i < words.length; i++){
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
                System.out.print(words[i]);
                if(i != s.length()-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}