import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class J03010_DiaChiEmail {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        ArrayList<String> ds = new ArrayList<>();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine().trim();
            s = s.toLowerCase();
            String[] words = s.split("\\s+");
            String email = "";
            email = email + words[words.length - 1];
            for (int i = 0; i < words.length - 1; i++) {
                email = email + words[i].substring(0, 1);
            }
            ds.add(email);
            int dem = Collections.frequency(ds, email);
            email += (dem == 1 ? "" : dem) + "@ptit.edu.vn";
            System.out.println(email);
        }
    }
}