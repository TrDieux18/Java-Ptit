import java.util.*;

class PTGT {

    private String ma, hang;
    private Date ngayLanBanh;
    private double giaBan;
    private static int sMa = 1;

    public PTGT(String hang, Date ngayLanBanh, double giaBan) {
        this.hang = hang;
        this.ma = this.hang.toUpperCase().charAt(0) + String.format("%03d", sMa++);
        this.ngayLanBanh = ngayLanBanh;
        this.giaBan = giaBan;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public Date getNgayLanBanh() {
        return ngayLanBanh;
    }

    public void setNgayLanBanh(Date ngayLanBanh) {
        this.ngayLanBanh = ngayLanBanh;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public static int getsMa() {
        return sMa;
    }

    public static void setsMa(int sMa) {
        PTGT.sMa = sMa;
    }

    public int getNamLanBang() {
        return ngayLanBanh.getYear() + 1900;
    }

    public String ChuanHoa(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            ans.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        return ans.toString().trim();
    }

    @Override
    public String toString() {
        return getMa() + " " + ChuanHoa(getHang()) + " " + getNamLanBang() + " " + getGiaBan();
    }
};

class QLPT {
    private List<PTGT> a;

    public QLPT() {
        a = new ArrayList<>();
        a.add(new PTGT("yaris", new Date("11/21/2018"), 21000));
        a.add(new PTGT("mec", new Date("11/01/2018"), 28000));
        a.add(new PTGT("civic", new Date("05/05/2014"), 22000));
        a.add(new PTGT("audi", new Date("10/01/2024"), 260000));
    }

    public void out() {
        for (PTGT i : a) {
            System.out.println(i);
        }
        System.out.println("Tong: " + a.size());
    }

    public void out(List<PTGT> b) {
        for (PTGT i : b) {
            System.out.println(i);
        }
        System.out.println("Tong: " + b.size());
    }

    public void nhap(Scanner in) {
        a.add(new PTGT(in.nextLine(), new Date(in.nextLine()), Double.parseDouble(in.nextLine())));
    }

    public List<PTGT> timTheoHang(String key) {
        List<PTGT> b = new ArrayList<>();
        for (PTGT i : a) {
            if (i.getHang().toLowerCase().contains(key.toLowerCase())) {
                b.add(i);
            }
        }
        return b;
    }

    public List<PTGT> timTheoNam(int nam) {
        List<PTGT> b = new ArrayList<>();
        for (PTGT i : a) {
            if (i.getNamLanBang() == nam) {
                b.add(i);
            }
        }
        return b;
    }

    public int getVitri(String ma) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getMa().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    public void xoaMa(String ma) {
        int p = getVitri(ma);
        if (p == -1) {
            System.out.println("Khong tim thay!!");
        } else {
            a.remove(p);
            System.out.println("Xoa thanh cong");
        }
    }

    public void suaMa(String ma, Scanner in) {
        int p = getVitri(ma);
        if (p == -1) {
            System.out.println("Khong tim thay!!");
        } else {
            PTGT pt = a.get(p);
            pt.setHang(in.nextLine());
            pt.setNgayLanBanh(new Date(in.nextLine()));
            pt.setGiaBan(Double.parseDouble(in.nextLine()));
            System.out.println("Sua thanh cong");
        }
    }

    public void sapxepTheoGia() {
        System.out.println("Sap Xep Theo Gia Tang Dan:");
        a.sort((x, y) -> Double.compare(x.getGiaBan(), y.getGiaBan()));
    }

    public void sapxepTheoNam() {
        System.out.println("Sap Xep Theo Nam Tang Dan:");
        a.sort((x, y) -> Integer.compare(x.getNamLanBang(), y.getNamLanBang()));
    }

    public void sapxepTheoNgayLB() {
        System.out.println("Sap Xep Theo Ngay Tang Dan:");
        a.sort((x, y) -> x.getNgayLanBanh().compareTo(y.getNgayLanBanh()));
    }
}

public class C_PTGT {
    public static void main(String[] args) {
        QLPT q = new QLPT();
        Scanner in = new Scanner(System.in);
        q.out();
        System.out.println("-------------------");
        // List<PTGT> tim = q.timTheoHang(in.nextLine());
        // q.out(tim);
        // List<PTGT> tim = q.timTheoNam(in.nextInt());
        // q.out(tim);

        // q.xoaMa("B999");
        // q.xoaMa("Y001");
        // q.out();

        // q.suaMa("B999", in);
        // q.suaMa("Y001", in);
        q.sapxepTheoGia();
        q.out();
        System.out.println("-------------------");
        q.sapxepTheoNam();
        q.out();
        System.out.println("-------------------");
        q.sapxepTheoNgayLB();
        q.out();
        System.out.println("-------------------");
        in.close();
    }
}
