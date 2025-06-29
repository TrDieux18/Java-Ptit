import java.util.*;

class  giaoVien{

    private String id, name, mon;
    public static int cnt = 1;

    public giaoVien() {

    }

    public String getName() {
        return name;
    }

    public void Input(Scanner sc) {
        id = "GV" + String.format("%02d", cnt++);
        name = sc.nextLine();
        mon = sc.nextLine().toUpperCase();
    }

    public String formatMon(String s) {
        String ans = "";
        String[] words = s.trim().split("\\s+");
        for (String word : words) {
            ans += word.substring(0, 1);
        }
        return ans;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + formatMon(mon);
    }
};

public class J05027_TimKiemGiaoVien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<giaoVien> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            giaoVien gv = new giaoVien();
            gv.Input(sc);
            a.add(gv);
        }

        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            String s = sc.nextLine();
            System.out.println("DANH SACH GIANG VIEN THEO TU KHOA " + s + ":");
            for (giaoVien x : a) {
                if (x.getName().toUpperCase().contains(s.toUpperCase())) {
                    System.out.println(x);
                }
            }
        }
    }
}
