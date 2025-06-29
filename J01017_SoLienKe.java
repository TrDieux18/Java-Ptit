// package BaiTest;
import java.util.Scanner;

public class J01017_SoLienKe {
    public static Scanner sc = new Scanner(System.in);
    public static boolean check(String s){
    
        for(int  i = 1; i < s.length(); i++){
            if(Math.abs((s.charAt(i)-'0')-(s.charAt(i-1)-'0')) != 1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            if(check(s)){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}