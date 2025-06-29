import java.util.Scanner;

public class J03032_DaoTu {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine().trim();
            String[] words = s.split("\\s+");
            for(int i = 0; i < words.length; i++){
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
            for(int i = 0; i < words.length; i++){
                System.out.print(words[i] + " ");
            }
            System.out.println();
        }
    }
}
