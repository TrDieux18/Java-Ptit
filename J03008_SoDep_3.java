import java.util.Scanner;

public class J03008_SoDep_3 {
    public static Scanner sc = new Scanner(System.in);

    public static boolean check_3(String s){
        int l = 0, r = s.length() -1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++; r--;   
        }
        return true;
    }
    public static boolean check_4(String s){
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c  != '2' && c != '3' && c  != '5' && c  != '7'){
                return false;
            }
        }
        return true;
    }

   

    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            if(check_4(s) && check_3(s) ){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}