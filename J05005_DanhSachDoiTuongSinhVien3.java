import java.util.*;

class DsSinhvien3 {
    private String msv, hoten, lop, dob;
    private double gpa;
    public static int cnt = 1;

    public DsSinhvien3() {
        msv = "";
        hoten = "";
        lop = "";
        dob = "";
        gpa = 0;
    }

    public String getMsv() {
        return msv;
    }

    public double getGpa() {
        return gpa;
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

public class J05005_DanhSachDoiTuongSinhVien3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<DsSinhvien3> a = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            DsSinhvien3 sv = new DsSinhvien3();
            sv.input(sc);
            a.add(sv);
        }

        a.sort( new Comparator<DsSinhvien3>() {
            public int compare(DsSinhvien3 x, DsSinhvien3 y) {
                int ans = Double.compare(y.getGpa(), x.getGpa());
                if (ans != 0) {
                    return ans;
                }
                return x.getMsv().compareTo(y.getMsv());
            }
        });

        for (DsSinhvien3 i : a) {
            System.out.println(i);
        }

    }
}
