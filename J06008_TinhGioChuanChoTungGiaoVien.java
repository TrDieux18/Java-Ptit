
import java.util.*;

class MonHoc {

    private String maMon;
    private String tenMon;

    public MonHoc(String maMon, String tenMon) {
        this.maMon = maMon;
        this.tenMon = tenMon;
    }

    public String getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }
}

class GiangVien {

    private String maGV;
    private String tenGV;

    public GiangVien(String maGV, String tenGV) {
        this.maGV = maGV;
        this.tenGV = tenGV;
    }

    public String getMa() {
        return maGV;
    }

    public String getTen() {
        return tenGV;
    }
}

class LopHoc {

    private GiangVien giangVien;
    private MonHoc monHoc;
    private String gioGiang;

    public LopHoc(GiangVien giangVien, MonHoc monHoc, String gioGiang) {
        this.giangVien = giangVien;
        this.monHoc = monHoc;
        this.gioGiang = gioGiang;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public String getGioGiang() {
        return gioGiang;
    }

    @Override
    public String toString() {
        return monHoc.getTenMon() + " " + gioGiang;
    }
}

public class J06008_TinhGioChuanChoTungGiaoVien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        ArrayList<LopHoc> danhSachLopHoc = new ArrayList<>();
        HashMap<String, GiangVien> danhSachGiangVien = new HashMap<>();
        HashMap<String, MonHoc> danhSachMonHoc = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] ss = sc.nextLine().split(" ", 2);
            String maMon = ss[0];
            String tenMon = ss[1];
            MonHoc monHoc = new MonHoc(maMon, tenMon);
            danhSachMonHoc.put(maMon, monHoc);
        }

        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String[] sss = sc.nextLine().split(" ",2);
            String maGV = sss[0];
            String tenGV = sss[1];
            GiangVien giangVien = new GiangVien(maGV, tenGV);
            danhSachGiangVien.put(maGV, giangVien);
        }

        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < k; i++) {
            String[] tmp = sc.nextLine().split(" ");
            String maGV = tmp[0];
            String maMon = tmp[1];
            String gioGiang = tmp[2];
            LopHoc lopHoc = new LopHoc(danhSachGiangVien.get(maGV), danhSachMonHoc.get(maMon), gioGiang);
            danhSachLopHoc.add(lopHoc);
        }

        String key = sc.nextLine();
        System.out.println("Giang vien: " + danhSachGiangVien.get(key).getTen());
        double tongGioGiang = 0;
        for (LopHoc lop : danhSachLopHoc) {
            if (lop.getGiangVien().getMa().equals(key)) {
                System.out.println(lop);
                tongGioGiang += Double.parseDouble(lop.getGioGiang());
            }
        }
        System.out.printf("Tong: %.2f", tongGioGiang);
    }
}
