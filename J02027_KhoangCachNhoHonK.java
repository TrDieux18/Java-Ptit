import java.util.*;

public class J02027_KhoangCachNhoHonK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);
            long count = 0;
            int j = 0;

            for (int i = 0; i < n; i++) {
                while (j < n && a[j] - a[i] < k) {
                    j++;
                }

                count += (j - i - 1);
            }
            System.out.println(count); 
        }
        sc.close();
    }
}
