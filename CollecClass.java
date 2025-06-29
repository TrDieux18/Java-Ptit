import java.util.*;

class TaiLieu {

    private String ma, tenNXB;
    private int soBanPH;

    public TaiLieu() {

    }

    public String ChuanHoaTen(String s){
        String[] words = s.trim().toLowerCase().split("\\s+");
        StringBuilder ans = new StringBuilder();
        for(String i : words){
            ans.append(Character.toUpperCase(i.charAt(0))).append(i.substring(1)).append(" ");
        }
        return ans.toString().trim();
    }
    public TaiLieu(String ma, String tenNXB, int soBanPH) {
        this.ma = ma;
        this.tenNXB = ChuanHoaTen(tenNXB);
        this.soBanPH = soBanPH;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public int getSoBanPH() {
        return soBanPH;
    }

    public void setSoBanPH(int soBanPH) {
        this.soBanPH = soBanPH;
    }

};

class Sach extends TaiLieu {

    private String tenSach, tenTG;
    private int soTrang;

    public Sach() {

    }

    public Sach(String tenSach, String tenTG, int soTrang) {
        this.tenSach = ChuanHoaTen(tenSach);
        this.tenTG = ChuanHoaTen(tenTG);
        this.soTrang = soTrang;
    }

    public Sach(String ma, String tenSach, String tenTG, int soTrang, String tenNXB, int soBanPH) {
        super(ma, tenNXB, soBanPH);
        this.tenSach = ChuanHoaTen(tenSach);
        this.tenTG = ChuanHoaTen(tenTG);
        this.soTrang = soTrang;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTenTG() {
        return tenTG;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public String toString() {
        return getMa() + " " + tenSach + " " + tenTG + " " + soTrang + " " + getTenNXB() + " " + getSoBanPH();
    }

};

class TapChi extends TaiLieu {

    private int soPH, thang;

    public TapChi() {
    }

    public TapChi(String ma, int soPH, int thang, String tenNXB, int soBanPH) {
        super(ma, tenNXB, soBanPH);
        this.soPH = soPH;
        this.thang = thang;
    }

    public int getSoPH() {
        return soPH;
    }

    public void setSoPH(int soPH) {
        this.soPH = soPH;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public String toString() {
        return getMa().toUpperCase() + " " + soPH + " " + thang + " "
                + getTenNXB() + " " + getSoBanPH();
    }
}

interface ChucNang {

    public void nhapSach(Scanner in);

    public void nhapTapChi(Scanner in);

    public void out();// toan bo ds

    public <T> void out(List<T> arr);

    public void timTheoMa(String ma);// viet ra

    public List<Sach> timTheoTenSach(String key);

    public List<TaiLieu> timTheoTuDen(int from, int to);

    public void xoaMa(String ma);

    public void xoaNhieu(String tacGia);// sach

    public void suaCha(String ma, Scanner in);// tai lieu

    public void suaCon(String ma, Scanner in);// tap chi

    public void sapxepTheosoBanPH();// cha int

    public void sapxepTheoNXB();// cha String

    public List<Sach> sapxepTheoTenTG();// 2 tieu chi
};

class ThucHien implements ChucNang {
    private List<TaiLieu> a;

    public static int sMa = 1;

    public ThucHien() {
        a = new ArrayList<>();
    }

    public ThucHien(List<TaiLieu> a) {
        this.a = a;
    }

    private TaiLieu nhap(Scanner in) {
        TaiLieu t = new TaiLieu(String.format("%03d", sMa++), in.nextLine(), Integer.parseInt(in.nextLine()));
        return t;
    }

    @Override

    public void nhapSach(Scanner in) {
        TaiLieu t = nhap(in);
        Sach s = new Sach("S" + t.getMa(), in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine()), t.getTenNXB(),
                t.getSoBanPH());
        a.add(s);
    }

    @Override
    public void nhapTapChi(Scanner in) {
        TaiLieu t = nhap(in);
        TapChi tc = new TapChi("TC" + t.getMa(), Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()),
                t.getTenNXB(), t.getSoBanPH());
        a.add(tc);
    }

    @Override
    public void out() {
        // cach1
        for (TaiLieu i : a) {
            System.out.println(i);
        }

        // cach2
        // a.forEach(t -> System.out.println(t));
        // System.out.println("Tong: " + a.size());

        // cach3
        // for(int i = 0; i < a.size(); i++){
        // System.out.println(a.get(i));
        // }

    }

    // generic method
    @Override
    public <T> void out(List<T> arr) {
        arr.forEach(s -> System.out.println(s));
        System.out.println("Tong: " + arr.size());

    }

    @Override
    public void sapxepTheoNXB() {
        a.sort(new Comparator<TaiLieu>() {
            public int compare(TaiLieu x, TaiLieu y) {
                return x.getTenNXB().compareTo(y.getTenNXB());
            }
        });

    }

    @Override
    public List<Sach> sapxepTheoTenTG() {
        List<Sach> b = new ArrayList<>();
        for(TaiLieu i : a){
            if(i instanceof Sach){
                b.add((Sach) i);
            }
        }
        
        b.sort((x, y) -> x.getTenTG().compareTo(y.getTenTG()));
        return b;
    }

    @Override
    public void sapxepTheosoBanPH() {
        a.sort((x, y) -> x.getSoBanPH() - y.getSoBanPH());

    }

    @Override
    public void suaCha(String ma, Scanner in) {
        int p = getVitri(ma);
        if (p == -1) {
            System.out.println("Khong tim thay!!");
        } else {
            TaiLieu t = a.get(p);
            t.setTenNXB(in.nextLine());
            t.setSoBanPH(Integer.parseInt(in.nextLine()));
            System.out.println("Sua thanh cong");
        }

    }

    @Override
    public void suaCon(String ma, Scanner in) {
        // Sua Tap chi
        int p = getVitri(ma);
        if (p == -1) {
            System.out.println("Khong tim thay!!");
        } else {
            TapChi t = (TapChi) a.get(p);
            t.setTenNXB(in.nextLine());
            t.setSoBanPH(Integer.parseInt(in.nextLine()));
            t.setSoPH(Integer.parseInt(in.nextLine()));
            t.setThang(Integer.parseInt(in.nextLine()));
            System.out.println("Sua thanh cong");
        }
    }

    private int getVitri(String ma) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getMa().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void timTheoMa(String ma) {
        int p = getVitri(ma);
        if (p == -1) {
            System.out.println("Khong tim thay!!");
        } else {
            System.out.println(a.get(p));
        }

    }

    @Override
    public List<Sach> timTheoTenSach(String key) {
        List<Sach> b = new ArrayList<>();
        for (TaiLieu i : a) {
            if (i instanceof Sach && ((Sach) i).getTenSach().toLowerCase().contains(key.toLowerCase())) {
                b.add(((Sach) i));
            }
        }
        return b;
    }

    // Tìm số bản phát hành từ .. đến ..- về nhà làm
    @Override
    public List<TaiLieu> timTheoTuDen(int from, int to) {
        List<TaiLieu> b = new ArrayList<>();
        for (TaiLieu i : a) {
            if (i.getSoBanPH() >= from && i.getSoBanPH() <= to) {
                b.add(i);
            }
        }
        return b;
    }

    @Override
    public void xoaMa(String ma) {
        int p = getVitri(ma);
        if (p == -1) {
            System.out.println("Khong tim thay!!");
        } else {
            a.remove(p);
            System.out.println("Xoa thanh cong!!");
        }

    }

    // Xóa theo tên tác giả
    @Override
    public void xoaNhieu(String tacGia) {
        List<TaiLieu> dele= new ArrayList<>();
        for (TaiLieu i : a) {
            if (i instanceof Sach && ((Sach) i).getTenTG().equalsIgnoreCase(tacGia)) {
                dele.add(i);
            }
        }
        a.removeAll(dele);
    }

}

public class CollecClass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // th.nhapSach(in);
        // th.nhapTapChi(in);
        List<TaiLieu> a;
        a = new ArrayList<>();
        a.add(new Sach("S001", "Lap trinh HDT",
                "Tran Dinh Que",
                120, "PTIT", 1000));
        a.add(new Sach("S002", "Lap trinh android",
                "Tran dinh que",
                140, "PTIT", 800));
        a.add(new Sach("S003", "Ky thuat do hoa",
                "TRinh Thi Van Anh",
                125, "Buu chinh", 2000));
        a.add(new TapChi("TC004", 2, 6, "Nhi dong", 200));
        a.add(new TapChi("TC005", 1, 8, "PTIT", 100));
        ThucHien th = new ThucHien(a);
        // th.timTheoMa("b888");
        // th.timTheoMa("S002");
        // th.out(th.timTheoTenSach("lap trinh"));
        // th.xoaMa("B888");
        // th.xoaMa("S003");
        // th.suaCha("S002", in);
        // th.suaCon("TC004", in);
        // th.sapxepTheoNXB();
        // th.sapxepTheoTenTG();
        // th.sapxepTheosoBanPH();
        // List<TaiLieu> b =  th.timTheoTuDen(100, 900);
        // th.out(b);
        // th.xoaNhieu(in.nextLine());
        th.out();
        in.close();
    }
}