// package CodeJ;
import java.util.*;

class In {
    private Set<Integer> set;

    public In() {
        set = new TreeSet<>();
    }

    public In(int[] arr) {
        set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }
    }

    public In union(In other) {
        In ans = new In();
        ans.set.addAll(this.set);
        ans.set.addAll(other.set);
        return ans;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i : set) {
            res.append(i).append(" ");
        }
        return res.toString().trim();
    }
}

public class LopIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();
        In s1 = new In(a);
        In s2 = new In(b);
        In s3 = s1.union(s2);
        System.out.println(s3);
        sc.close();
    }
}
