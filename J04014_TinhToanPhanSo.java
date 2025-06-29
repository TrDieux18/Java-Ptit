import java.util.Scanner;

class TinhToanPhanSo {
    private long tu, mau;

    public TinhToanPhanSo() {

    }

    public TinhToanPhanSo(long tu, long mau) {
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

    public TinhToanPhanSo TongPS(TinhToanPhanSo B) {
        long mc = lcm(this.mau, B.getMau());
        long tc = (mc / this.mau) * this.tu + (mc / B.getMau()) * B.getTu();
        TinhToanPhanSo C = new TinhToanPhanSo(tc, mc);
        C.rutgon();
        return C;
    }
    
    public TinhToanPhanSo BinhPhuong() {
        return new TinhToanPhanSo(this.tu * this.tu, this.mau * this.mau);
    }

    public TinhToanPhanSo TichPS(TinhToanPhanSo B) {
        TinhToanPhanSo C = new TinhToanPhanSo(this.tu * B.tu, this.mau * B.mau);
        C.rutgon();
        return C;
    }

    public String toString() {
        return this.tu + "/" + this.mau;
    }
}

public class J04014_TinhToanPhanSo {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            long tuA = sc.nextLong();
            long mauA = sc.nextLong();
            long tuB = sc.nextLong();
            long mauB = sc.nextLong();

            TinhToanPhanSo A = new TinhToanPhanSo(tuA, mauA);
            TinhToanPhanSo B = new TinhToanPhanSo(tuB, mauB);

            TinhToanPhanSo C = A.TongPS(B).BinhPhuong();
            TinhToanPhanSo D = A.TichPS(B).TichPS(C);
            System.out.println(C + " " + D);
        }
        sc.close();
    }
}
