import java.util.*;

class LkSinhVien2 {

    private String id, name, lop, email;

    public LkSinhVien2() {

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

public class J05023_LietKeSinhVienTheoKhoa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<LkSinhVien2> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            LkSinhVien2 sv = new LkSinhVien2();
            sv.Input(sc);
            a.add(sv);
        }

        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            String s = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN KHOA " + s + ":");

            for (LkSinhVien2 x : a) {
                if (x.getLop().substring(1,3).equals(s.substring(2)))
                    System.out.println(x);
            }
        }
    }
}