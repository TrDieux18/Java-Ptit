import java.util.*;

class QLXD {

    private String id;
    private int soLuong;

    public QLXD() {

    }

    public void Input(Scanner sc) {
        id = sc.next();
        soLuong = Integer.parseInt(sc.next());
    }

    public long getDonGia() {
        long ans = 0;
        String res = id.substring(0, 1);
        if (res.equals("X")) {
            ans = 128000;
        }
        if (res.equals("D")) {
            ans = 11200;
        }
        if (res.equals("N")) {
            ans = 9700;
        }
        return ans;
    }

    public long getThue() {
        double ans = 0;
        long tong = getDonGia() * soLuong;
        String hang = getTenHang();

        if (!hang.equals("Trong Nuoc")) {
            String res = id.substring(0, 1);
            if (res.equals("X")) {
                ans = tong * 0.03;
            }
            if (res.equals("D")) {
                ans = tong * 0.035;
            }
            if (res.equals("N")) {
                ans = tong * 0.02;
            }
        }
        return (long) ans;
    }

    public String getTenHang() {
        String res = id.substring(id.length() - 2);
        String ans = "";
        if (res.equals("BP")) {
            ans = "British Petro";
        }
        if (res.equals("ES")) {
            ans = "Esso";
        }
        if (res.equals("SH")) {
            ans = "Shell";
        }
        if (res.equals("CA")) {
            ans = "Castrol";
        }
        if (res.equals("MO")) {
            ans = "Mobil";
        }
        if (res.equals("TN")) {
            ans = "Trong Nuoc";
        }
        return ans;
    }

    public long getThanhTien() {
        return (soLuong * getDonGia()) + getThue();
    }

    @Override
    public String toString() {
        return id + " " + getTenHang() + " " + getDonGia() + " " + getThue() + " " + getThanhTien();
    }
};

public class J05067_QuanLyKhoXangDau {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        QLXD[] a = new QLXD[n];
        for (int i = 0; i < n; i++) {
            a[i] = new QLXD();
            a[i].Input(sc);
        }

        for (QLXD i : a) {
            System.out.println(i);
        }
    }
}
