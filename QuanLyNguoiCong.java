import java.util.Collection;
import java.util.Scanner;

class NguoiCong {

    private String ma, hoten, sdt;
    private double hsl;
    private int dob;
    public static int sma = 1;

    public NguoiCong() {

    }

    public void Input(Scanner sc) {

        hoten = sc.nextLine();
        dob = Integer.parseInt(sc.nextLine());
        hsl = Double.parseDouble(sc.nextLine());
        sdt = sc.nextLine();
    }

    public String getMa() {
        ma = ("E" + String.format("%03d", sma++));
        return ma;
    }

    public int getTuoi() {
        return 2024 - dob;
    }

    @Override
    public String toString() {
        return getMa() + " " + hoten + " " + getTuoi() + " " + sdt + " " + String.format("%.1f", hsl * 10000);
    }

};

class QLNC {

    private NguoiCong[] a;

    public QLNC(NguoiCong[] a) {
        this.a = a;
    }

    public void out() {
        for (NguoiCong i : a) {
            System.out.println(i);
        }
    }

};

public class QuanLyNguoiCong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        NguoiCong[] nn = new NguoiCong[n];
        for (int i = 0; i < n; i++) {
            nn[i] = new NguoiCong();
            nn[i].Input(sc);
        }
        // Collection.oco

        QLNC q = new QLNC(nn);
        q.out();
    }
}
