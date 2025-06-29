import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07004_SoKhacNhauTrongFile1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int[] cnt = new int[1001];
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.next());
            cnt[n]++;
        }
        for (int i = 0; i < 1001; i++) {
            if (cnt[i] > 0) {
                System.out.println(i + " " + cnt[i]);
            }
        }
        sc.close();
    }
}
