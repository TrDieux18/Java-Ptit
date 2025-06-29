import java.util.ArrayList;
// import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class J02024_DayConCoTongLe {

    public static int n;
    public static int[] a;
    public static int[] b;
    public static List<String> res;

    
    public static boolean Tongle(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum % 2 == 1;
    }


    public static void out() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (b[i] == 1) {
                list.add(a[i]);
            }
        }

       
        if (Tongle(list)) {
            StringBuilder s = new StringBuilder();
            for (Integer i : list) {
                s.append(i).append(" ");
            }
            res.add(s.toString().trim());
        }
    }

   
    public static void Try(int i) {
        for (int j = 0; j <= 1; j++) {
            b[i] = j;
            if (i == n - 1) {
                out();  
            } else {
                Try(i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); 
        while (t-- > 0) {
            n = sc.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);
            for (int i = 0; i < n / 2; i++) {
                int temp = a[i];
                a[i] = a[n - i - 1];
                a[n - i - 1] = temp;
            }

            b = new int[n]; 
            res = new ArrayList<>();
            Try(0);

            // Collections.sort(res);

            for (String s : res) {
                System.out.println(s);
            }
        }
        sc.close();
    }
}
