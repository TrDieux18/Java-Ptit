import java.util.Scanner;

class TongPhanSo {
    private long tu, mau;

    public TongPhanSo() {

    }

    public TongPhanSo(long tu, long mau) {
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
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public void rutgon() {
        long g = gcd(this.tu, this.mau);
        this.tu /= g;
        this.mau /= g;
    }

    public TongPhanSo TongPS(TongPhanSo B) {
        long mc = lcm(this.mau, B.getMau());
        long tc = (mc / this.mau) * this.tu + (mc / B.getMau()) * B.getTu();
        TongPhanSo C = new TongPhanSo(tc, mc);
        C.rutgon();
        return C;
    }

    
    public String toString() {
        return this.tu + "/" + this.mau;
    }
}

public class J04004_TongPhanSo {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long a = sc.nextLong();
        long b = sc.nextLong();
        TongPhanSo C = new TongPhanSo(a, b);
        long c = sc.nextLong();
        long d = sc.nextLong();
        TongPhanSo D = new TongPhanSo(c, d);
        TongPhanSo E = C.TongPS(D);
        System.out.println(E);
    }
}