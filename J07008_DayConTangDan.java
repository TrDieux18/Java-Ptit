import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J07008_DayConTangDan {

    private static int n;
    private static int[] a;
    private static int[] b;
    private static List<String> res;

    // Hàm kiểm tra xem một dãy con có phải là dãy tăng dần hay không
    private static void check() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (b[i] == 1) {
                list.add(a[i]);
            }
        }

        // Nếu dãy con có từ 2 phần tử trở lên và tăng dần, thêm vào kết quả
        if (list.size() >= 2) {
            boolean isAscending = true;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) <= list.get(i - 1)) {
                    isAscending = false;
                    break;
                }
            }
            if (isAscending) {
                StringBuilder s = new StringBuilder();
                for (Integer i : list) {
                    s.append(i).append(" ");
                }
                res.add(s.toString().trim());
            }
        }
    }

    // Hàm thực hiện Backtracking
    private static void Try(int i) {
        for (int j = 0; j <= 1; j++) {
            b[i] = j;
            if (i == n - 1) {
                check();
            } else {
                Try(i + 1);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("DAYSO.in"));
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        b = new int[n];
        res = new ArrayList<>();
        Try(0);

        Collections.sort(res);
        for (String i : res) {
            System.out.println(i);
        }
        

        sc.close();
    }
}
