import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class J02009_XepHang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, Integer> a = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int d = sc.nextInt();
            a.put(t, d);
        }
        int ans = 0;

        for (Map.Entry<Integer, Integer> i : a.entrySet()) {
            int tgden = i.getKey();  
            int tgcan = i.getValue(); 

            if (tgden > ans) {
                ans = tgden;
            }
            ans += tgcan;
        }
        System.out.println(ans);
        sc.close();
    }
}
