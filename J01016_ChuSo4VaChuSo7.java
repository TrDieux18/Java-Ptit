// package BaiTest;
import java.util.Scanner;

public class J01016_ChuSo4VaChuSo7 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '4' || s.charAt(i) == '7'){
                ++sum;
            }
        }
        if(sum == 7 || sum == 4){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        sc.close();
    }
}