import java.util.Scanner;

public class J03040_BienSoDep {

    public static boolean Check1(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) >= s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean Check2(String s) {
        return (s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2) && s.charAt(3) == s.charAt(4));
    }

    public static boolean Check3(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '6' && s.charAt(i) != '8'){
                return false;
            }
        }
        return true;
    }

    public static boolean isBeauty(String s){
        String ans = s.split("-")[1].replace(".","");
        return (Check1(ans) || Check2(ans) || Check3(ans));
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            if(isBeauty(s)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
