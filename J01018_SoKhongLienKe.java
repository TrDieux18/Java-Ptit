// package BaiTest;
import java.util.Scanner;

public class J01018_SoKhongLienKe {
    public static Scanner sc = new Scanner(System.in);
    public static boolean check(String s){
        for(int  i = 1; i < s.length(); i++){
            if(Math.abs((s.charAt(i)-'0')-(s.charAt(i-1)-'0')) != 2){
                return false;
            }
        }
        return true;
    }

    public static boolean check2(String s){
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            sum += (s.charAt(i) - '0');
        }
        if(sum % 10 != 0) return false;
        else return true; 
    }
    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            if(check(s) && check2(s)){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}