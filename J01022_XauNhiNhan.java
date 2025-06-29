import java.util.Scanner;

public class J01022_XauNhiNhan {

    public static long[] fibonacci(int n) {
        long[] fib = new long[n + 1];
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    public static char findChar(int n, long k, long[] f) {
        while (n > 2) {
            if (k <= f[n - 2]) {
                n -= 2;
            } else {
                k -= f[n - 2];
                n -= 1;
            }
        }
        return (n == 1) ? '0' : '1';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] fib = fibonacci(93);
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            System.out.println(findChar(n, k, fib));
        }
        sc.close();
    }
}

// Nếu mà k > f[n-2] thì nó nằm trong f[n-1] còn <= thì nó nằm trong f[n-2]
// ví dụ X[3] = '01'
// n = 3, k = 2
// k > f[n-2] (f[3-2] = f[1] = 1)
// k = 2, f[1] = 1 => k -=1 => k = 1
// n -= 1 => n = 2 đã sai điều kiện while nên thoát => n == 2 != 1 trả về kí tự
// '1'