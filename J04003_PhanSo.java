import java.util.Scanner;

// import java.util.Math;
class PhanSo {

    private long tu, mau;

    public PhanSo() {

    }

    public PhanSo(long tu, long mau) {
        this.mau = mau;
        this.tu = tu;
    }

    public long getTu() {
        return tu;
    }

    public void setTu(long tu) {
        this.tu = tu;
    }

    public long getMau() {
        return mau;
    }

    public void setMau(long mau) {
        this.mau = mau;
    }

    public long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public String rutgon(PhanSo A) {
        long g = gcd(A.getTu(), A.getMau());
        return A.getTu() / g + "/" + A.getMau() / g;
    }
};

public class J04003_PhanSo {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long a = sc.nextLong();
        long b = sc.nextLong();
        PhanSo A = new PhanSo(a, b);
        System.out.println(A.rutgon(A));
    }
}