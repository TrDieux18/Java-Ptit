import java.util.*;

class LkSinhVien {

    private String id, name, lop, email;

    public LkSinhVien() {

    }

    public String getLop() {
        return this.lop;
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
};

public class J05022_LietKeSinhVienTheoLop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<LkSinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            LkSinhVien sv = new LkSinhVien();
            sv.Input(sc);
            a.add(sv);
        }

        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            String s = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN LOP " + s + ":");

            for (LkSinhVien x : a) {
                if (x.getLop().equals(s))
                    System.out.println(x);
            }
        }
    }
}
