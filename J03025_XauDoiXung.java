import java.util.Scanner;

public class J03025_XauDoiXung {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            int sum = 0;
            int l = 0, r = s.length() - 1;
            while(l < r){
                if(s.charAt(l) != s.charAt(r)){
                    sum++;
                }
                l++;
                r--;
            }
            if ((s.length() % 2 == 0 && sum == 1) || (s.length() % 2 == 1 && sum <= 1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }    
        sc.close();
    }
}

