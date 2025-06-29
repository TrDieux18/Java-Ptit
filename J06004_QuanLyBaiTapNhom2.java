
import java.util.ArrayList;
// import java.util.HashMap;
import java.util.List;
// import java.util.Map;
import java.util.Scanner;
// import java.util.TreeMap;

class BTL2 {

    private String ma;
    private String hoten;
    private String sdt;
    private int nhom;

    public BTL2(String ma, String hoten, String sdt, int nhom) {
        this.ma = ma;
        this.hoten = hoten;
        this.sdt = sdt;
        this.nhom = nhom;
    }

    public String getMa() {
        return ma;
    }

    public int getNhom() {
        return nhom;
    }

    @Override
    public String toString() {
        return ma + " " + hoten + " " + sdt + " " + nhom;
    }
}

public class J06004_QuanLyBaiTapNhom2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số lượng sinh viên và số nhóm
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Danh sách sinh viên
        List<BTL2> BTL2s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            BTL2s.add(new BTL2(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt()));
        }

        // Danh sách bài tập
        String[] s = new String[m + 1];
        sc.nextLine();
        for (int i = 1; i <= m; i++) {
            s[i] = sc.nextLine();
        }

        BTL2s.sort((o1, o2) -> o1.getMa().compareTo(o2.getMa()));

        for (BTL2 i : BTL2s) {
            System.out.println(i + " " + s[i.getNhom()]);
        }
        sc.close();
    }
}
