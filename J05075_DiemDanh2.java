import java.util.*;

class DD2 {

    private String id, name, lop, ghiChu;
    private int diemCC;

    public DD2() {
        this.diemCC = 10;
        this.ghiChu = "";
    }

    public void Input(Scanner in) {
        id = in.nextLine();
        name = in.nextLine();
        lop = in.nextLine();
    }

    public String getId() {
        return id;
    }

    public String getLop() {
        return lop;
    }

    public void getDiemCC(String dd) {
        int d = 10;
        for (char c : dd.toCharArray()) {
            if (c == 'm') {
                d -= 1;
            } else if (c == 'v') {
                d -= 2;
            }
        }

        this.diemCC = Math.max(d, 0);
        if(this.diemCC == 0){
            this.ghiChu = "KDDK";
        }
    }

    @Override
    public String toString() {
        return id + " " + name + " " + lop + " " + diemCC + (ghiChu.isEmpty() ? "" : " " + ghiChu);
    }
}

public class J05075_DiemDanh2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        DD2[] a = new DD2[n];
        for (int i = 0; i < n; i++) {
            a[i] = new DD2();
            a[i].Input(in);
        }

        for (int i = 0; i < n; i++) {
            String[] data = in.nextLine().split(" ");
            String maSV = data[0];
            String dd = data[1];

            for (DD2 c : a) {
                if (c.getId().equalsIgnoreCase(maSV)) {
                    c.getDiemCC(dd);
                }
            }
        }

        String ans = in.nextLine();
        for (DD2 i : a) {
            if (i.getLop().equals(ans)) {
                System.out.println(i);
            }
        }
    }

}
