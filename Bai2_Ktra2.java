import java.util.*;

class LTXB {

    private String id, name;
    private String date;
    private int soHieu, soLuot;
    private String kieuNgay;
    public static int sMa = 1;

    public LTXB(String name, String date, int soHieu, int soLuot, String kieuNgay) {
        this.name = name;
        this.date = date;
        this.soHieu = soHieu;
        this.id = "HN" + String.valueOf(soHieu) + String.format("%02d", sMa++);
        this.soLuot = soLuot;
        this.kieuNgay = kieuNgay;
    }

    public int getDoanhThu() {
        int tinh = 0;

        if (soLuot < 5) {
            tinh = 800;
        }
        if (soLuot > 10) {
            tinh = 750;
        }
        if (soLuot >= 5 && soLuot <= 10) {
            tinh = 780;
        }

        int tong = tinh * soLuot;
        if (kieuNgay.equalsIgnoreCase("nghi")) {
            tong += tong * 0.1;
        }
        if (kieuNgay.equalsIgnoreCase("le")) {
            tong += tong * 0.2;
        }

        return Math.round(tong);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSoHieu(int soHieu) {
        this.soHieu = soHieu;
    }

    public void setSoLuot(int soLuot) {
        this.soLuot = soLuot;
    }

    public void setKieuNgay(String kieuNgay) {
        this.kieuNgay = kieuNgay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + date + " " + soHieu + " " + soLuot + " " + kieuNgay + " " + getDoanhThu();
    }

};

class QLXB {

    private List<LTXB> a;

    public QLXB(List<LTXB> a) {
        this.a = a;
    }

    public int getViTri(String ma) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getId().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    public void suaMa(String ma, Scanner in) {
        int p = getViTri(ma);
        if (p == -1) {
            System.out.println("khong tim thay");
        } else {
            System.out.println(a.get(p));
            LTXB pt = a.get(p);
            pt.setName(in.nextLine());
            pt.setSoLuot(Integer.parseInt(in.nextLine()));
            pt.setKieuNgay(in.nextLine());
            System.out.println(a.get(p));
        }
    }

};

public class Bai2_Ktra2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<LTXB> a = new ArrayList<>();
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            a.add(new LTXB(in.nextLine(), in.nextLine(),
                    Integer.parseInt(in.nextLine()),
                    Integer.parseInt(in.nextLine()), in.nextLine()));
        }

        String key = in.nextLine();

        // QLXB b =new QLXB(a);
        // b.suaMa(key, in);
        boolean found = false;
        for (LTXB ltxb : a) {
            if (ltxb.getId().equalsIgnoreCase(key)) {
                System.out.println(ltxb);
                found = true;
                ltxb.setName(in.nextLine());
                ltxb.setSoLuot(Integer.parseInt(in.nextLine()));
                ltxb.setKieuNgay(in.nextLine());
                System.out.println(ltxb);
                break;
            }
        }

        if (!found) {
            System.out.println("khong tim thay");
        }

        in.close();
    }
}
