import java.util.Scanner;

public class J03006_SoDep_1 {
    public static Scanner sc = new Scanner(System.in);
    public static boolean check_1(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) % 2 != 0){
                return false;
            }
        }
        return true;
    }
    public static boolean check_2(String s){
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++; r--;
        }
        return true;
    }
    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            if(check_1(s) && check_2(s)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}