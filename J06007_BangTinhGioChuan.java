package CodePTIT;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class J06007_BangTinhGioChuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
        }

        int m = Integer.parseInt(sc.nextLine());
        Map<String, String> mp = new LinkedHashMap<>();
        Map<String, Double> mpthoiGian = new LinkedHashMap<>();
        for (int i = 0; i < m; i++) {
            String[] data = sc.nextLine().split(" ", 2);
            mp.put(data[0], data[1]);
            mpthoiGian.put(data[0], 0.0);
        }

        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < k; i++) {
            String[] data = sc.nextLine().split(" ");
            String maGV = data[0];
            double thoiGian = Double.parseDouble(data[2]);

            if (mpthoiGian.containsKey(maGV)) {
                mpthoiGian.put(maGV, mpthoiGian.get(maGV) + thoiGian);
            }
        }

        for (String i : mp.keySet()) {
            System.out.printf("%s %.2f\n", mp.get(i), mpthoiGian.get(i));
        }
    }
}
