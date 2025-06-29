import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class J07022_LoaiBoSoNguyen {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        ArrayList<String> a = new ArrayList<>();
        while (sc.hasNext()) {
            String s = sc.next();
            try {
                // int n = Integer.valueOf(s);
            } catch (NumberFormatException e) {
                a.add(s);
            }
        }

        Collections.sort(a);
        for (String i : a) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
