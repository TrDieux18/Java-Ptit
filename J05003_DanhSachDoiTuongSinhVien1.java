import java.util.*;

class DsSinhvien {
    private String msv, hoten, lop, dob;
    private double gpa;
    public static int cnt = 1;

    public DsSinhvien() {
        msv = "";
        hoten = "";
        lop = "";
        dob = "";
        gpa = 0;
    }

    public void input(Scanner sc) {
        msv = "B20DCCN" + String.format("%03d", cnt++);
        hoten = sc.nextLine();
        lop = sc.nextLine();
        dob = sc.nextLine();
        if (dob.charAt(2) != '/') {
            dob = "0" + dob;
        }
        if (dob.charAt(5) != '/') {
            dob = dob.substring(0, 3) + "0" + dob.substring(3);
        }
        gpa = Double.parseDouble(sc.nextLine());
    }

    public String toString() {
        return msv + " " + hoten + " " + lop + " " + dob + " " + String.format("%.2f", gpa);
    }

}

public class J05003_DanhSachDoiTuongSinhVien1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        DsSinhvien[] a = new DsSinhvien[n];

        for (int i = 0; i < n; i++) {
            a[i] = new DsSinhvien();
            a[i].input(sc);
        }

        for (DsSinhvien i : a) {
            System.out.println(i);
        }

    }
}
