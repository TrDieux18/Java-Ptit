// package BaiTest;
import java.util.Scanner;

public class J01024_SoTamPhan {
    public static Scanner sc = new Scanner(System.in);
    
    public static void check_2(){
        String s = sc.next();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) < '0' || s.charAt(i) > '2'){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    
    public static void main(String[] args){
        int t = sc.nextInt();
        while(t-- >0){
            check_2();
        }
    }
}