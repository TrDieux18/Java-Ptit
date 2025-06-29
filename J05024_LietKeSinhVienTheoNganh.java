import java.util.*;

class LkSinhVien3 {

    private String id, name, lop, email;

    public LkSinhVien3() {

    }

    public String getId() {
        return id;
    }

    public String check() {
        String s = "";
        if (id.contains("DCKT")) {
            s = "KE TOAN";
        } else if (id.contains("DCCN") && !lop.startsWith("E")) {
            s = "CONG NGHE THONG TIN";
        } else if (id.contains("DCAT") && !lop.startsWith("E")) {
            s = "AN TOAN THONG TIN";
        } else if (id.contains("DCVT")) {
            s = "VIEN THONG";
        } else if (id.contains("DCDT")) {
            s = "DIEN TU";
        }
        return s;
    }

    public void Input(Scanner sc) {
        id = sc.nextLine();
        name = sc.nextLine();
        lop = sc.nextLine();
        email = sc.nextLine();
    }

    @Override
    public String toString() {
        return id + " " + name + " " + lop + " " + email;
    }

}

public class J05024_LietKeSinhVienTheoNganh {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<LkSinhVien3> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            LkSinhVien3 sv = new LkSinhVien3();
            sv.Input(sc);
            a.add(sv);
        }

        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            String ans = sc.nextLine().toUpperCase();
            System.out.println("DANH SACH SINH VIEN NGANH " + ans + ":");
            for (LkSinhVien3 x : a) {
                if (x.check().equals(ans)) {
                    System.out.println(x);
                }
            }
        }
    }
}
