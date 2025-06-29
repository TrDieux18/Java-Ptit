import java.util.Scanner;

public class J03038_DanhDauChuCai {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sc.next();
        int[] cnt = new int[127];

        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i)]++;
        }

        int dem = 0;
        for(char i = 'a' ; i <= 'z'; i++){
            if(cnt[i] > 0){
                dem++;
            }
        }
        System.out.println(dem);
    }
}