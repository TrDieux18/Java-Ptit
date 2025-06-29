import java.util.*;

class HocSinh {
    private String id, name;
    private double toan, tviet, nngu, ly, hoa, sinh, lsu, dly, gdcd, cn;
    public static int cnt = 1;

    public HocSinh() {
    }

    public void input(Scanner sc) {
        id = "HS" + String.format("%02d", cnt++);
        name = sc.nextLine();


        toan = Double.parseDouble(sc.next());
        tviet = Double.parseDouble(sc.next());
        nngu = Double.parseDouble(sc.next());
        ly = Double.parseDouble(sc.next());
        hoa = Double.parseDouble(sc.next());
        sinh = Double.parseDouble(sc.next());
        lsu = Double.parseDouble(sc.next());
        dly = Double.parseDouble(sc.next());
        gdcd = Double.parseDouble(sc.next());
        cn = Double.parseDouble(sc.nextLine());
    }

    public double getDiemTB() {
        double score = (this.toan * 2 + this.tviet * 2 + this.nngu + this.ly + this.hoa + this.sinh + this.lsu + this.dly + this.gdcd + this.cn) / 12;
        score = Math.round(score *10)/ 10.0f;
        return score;
    }

    public String getId() {
        return id;
    }

    public String XepLoai() {
        String s;
        double diemTB = getDiemTB();
        if (diemTB >= 9) {
            s = "XUAT SAC";
        } else if (diemTB >= 8) {
            s = "GIOI";
        } else if (diemTB >= 7) {
            s = "KHA";
        } else if (diemTB >= 5) {
            s = "TB";
        } else {
            s = "YEU";
        }
        return s;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + String.format("%.1f", getDiemTB()) + " " + XepLoai();
    }
}

public class J05018_BangDiemHocSinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<HocSinh> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            HocSinh hs = new HocSinh();
            hs.input(sc);
            a.add(hs);
        }

        a.sort( new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                int ans = Double.compare(o2.getDiemTB(), o1.getDiemTB());
                if (ans != 0) {
                    return ans;
                }
                return o1.getId().compareTo(o2.getId());
            }
        });

        for (HocSinh i : a) {
            System.out.println(i);
        }
    }
}
