import java.util.Scanner;

class TuyenSinh {
    private String mts, hoten;
    private double toan, ly, hoa;

    public void input(Scanner sc) {
        mts = sc.nextLine();
        hoten = sc.nextLine();
        toan = Double.parseDouble(sc.nextLine());
        ly = Double.parseDouble(sc.nextLine());
        hoa = Double.parseDouble(sc.nextLine());

    }

    public double getTong() {
        return toan * 2 + ly + hoa;
    }

    public double getDiemUuTien() {
        double diemuutien = 0;
        if (mts.substring(0,3).equals("KV1")) {
            diemuutien = 0.5;
        }
        if (mts.substring(0,3).equals("KV2")) {
            diemuutien = 1.0;
        }
        if (mts.substring(0, 3).equals("KV3")) {
            diemuutien = 2.5;
        }
        return diemuutien;
    }

    public double getKq() {
        return getTong() + getDiemUuTien();
    }

    public String getTuyen() {
        if (getKq() < 24) {
            return "TRUOT";
        } else
            return "TRUNG TUYEN";
    }

    public String formatDouble(double x){
        int change = (int) (x*10);
        if(change % 10 == 0){
            return String.format("%.0f", x);
        }
        else{
            return String.format("%.1f", x);
        }

    }
    @Override
    public String toString() {
        return mts + " " +hoten + " " + formatDouble(getDiemUuTien()) + " " + formatDouble(getTong()) + " " + getTuyen();
    }

};

public class J04013_BaiToanTuyenSing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TuyenSinh ts = new TuyenSinh();
        ts.input(sc);
        System.out.println(ts);

    }
}