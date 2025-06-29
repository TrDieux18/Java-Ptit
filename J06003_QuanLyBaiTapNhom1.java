import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BaiTapNhom {

    private String ma;
    private String hoten;
    private String sdt;
    private int nhom;

    public BaiTapNhom(String ma, String hoten, String sdt, int nhom) {
        this.ma = ma;
        this.hoten = hoten;
        this.sdt = sdt;
        this.nhom = nhom;
    }

    public int getNhom() {
        return nhom;
    }

    @Override
    public String toString() {
        return ma + " " + hoten + " " + sdt;
    }
}

public class J06003_QuanLyBaiTapNhom1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số lượng sinh viên và số nhóm
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Danh sách sinh viên
        List<BaiTapNhom> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            students.add(new BaiTapNhom(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt()));
        }

        // Danh sách bài tập
        String[] s = new String[m + 1];
        sc.nextLine();
        for (int i = 1; i <= m; i++) {
            s[i] = sc.nextLine();
        }

        // Số lượng truy vấn
        int q = Integer.parseInt(sc.nextLine());

        // Xử lý từng truy vấn
        for (int i = 0; i < q; i++) {
            int key = Integer.parseInt(sc.nextLine());
            System.out.println("DANH SACH NHOM " + key + ":");
            for (BaiTapNhom student : students) {
                if (student.getNhom() == key) {
                    System.out.println(student);
                }
            }
            System.out.println("Bai tap dang ky: " + s[key]);
        }
        sc.close();
    }
}
