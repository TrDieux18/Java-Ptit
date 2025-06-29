import java.util.*;

class GiangV {

    private String id, name, mon;
    public static int cnt = 1;

    public GiangV() {

    }

    
    public String getMon() {
        return mon;
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

public class J05026_DanhSachGiangVienTheoBoMon {

    public static String formatMon(String s) {
        String ans = "";
        String[] words = s.trim().split("\\s+");
        for (String word : words) {
            ans += word.substring(0, 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<GiangV> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            GiangV gv = new GiangV();
            gv.Input(sc);
            a.add(gv);
        }

        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            String s = sc.nextLine().toUpperCase();
            System.out.println("DANH SACH GIANG VIEN BO MON " + formatMon(s) +":");
            for(GiangV x : a){
                if(x.getMon().equals(s)){
                    System.out.println(x);
                }
            }
        }
    }
}
