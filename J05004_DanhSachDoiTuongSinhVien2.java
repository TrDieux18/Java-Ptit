import java.util.*;

class DsSinhvien2 {
    private String msv, hoten, lop, dob;
    private double gpa;
    public static int cnt = 1;

    public DsSinhvien2() {
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

    public String Chuanhoa(String hoten) {
        String[] words = hoten.split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            ans.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        return ans.toString().trim();
    }

    public String toString() {
        return msv + " " + Chuanhoa(hoten.trim()) + " " + lop + " " + dob + " " + String.format("%.2f", gpa);
    }

}

public class J05004_DanhSachDoiTuongSinhVien2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        DsSinhvien2[] a = new DsSinhvien2[n];

        for (int i = 0; i < n; i++) {
            a[i] = new DsSinhvien2();
            a[i].input(sc);
        }

        for (DsSinhvien2 i : a) {
            System.out.println(i);
        }

    }
}
