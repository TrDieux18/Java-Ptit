
import java.util.Scanner;

class TinhCong {
    private String mnv, hoten, chucvu;
    private int lcb, snc;

    public TinhCong() {

    }

    public int getLcb() {
        return lcb;
    }

    public int getSnc() {
        return snc;
    }

    public void Input(Scanner sc) {
        hoten = sc.nextLine();
        lcb = Integer.parseInt(sc.nextLine());
        snc = Integer.parseInt(sc.nextLine());
        chucvu = sc.nextLine();
    }

    public int getLt() {
        return getLcb() * getSnc();
    }

    public int getThuong() {
        double thuong = 0;
        if (getSnc() < 22) {
            thuong = 0;
        }
        if (getSnc() >= 22 && getSnc() < 25) {
            thuong = getLt() * 0.1;
        }
        if (getSnc() >= 25) {
            thuong = getLt() * 0.2;
        }
        return (int) thuong;
    }

    public int getPc() {
        int phucap = 0;
        if (chucvu.equals("GD"))
            phucap = 250000;
        if (chucvu.equals("PGD"))
            phucap = 200000;
        if (chucvu.equals("TP"))
            phucap = 180000;
        if (chucvu.equals("NV"))
            phucap = 150000;
        return phucap;
    }

    public int getTong() {
        return getLt() + getThuong() + getPc();
    }

    @Override
    public String toString() {
        mnv = "NV01";
        return mnv + " " + hoten + " " + getLt() + " " + getThuong() + " " + getPc() + " " + getTong();
    }

};

public class J04012_BaiToanTinhCong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TinhCong nv = new TinhCong();
        nv.Input(sc);
        System.out.println(nv);
    }
}