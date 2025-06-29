import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

class KhachSan {
    private String id, name, soPhong;
    private LocalDate ngayNhan, ngayTra;
    private int tienPhatSinh;

    public static int cnt = 1;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public KhachSan(String name, String soPhong, String ngayNhan, String ngayTra, int tienPhatSinh) {
        this.id = String.format("KH%02d", cnt++);
        this.name = name.trim();
        this.soPhong = soPhong.trim();
        this.ngayNhan = LocalDate.parse(getChuan(ngayNhan), formatter);
        this.ngayTra = LocalDate.parse(getChuan(ngayTra), formatter);
        this.tienPhatSinh = tienPhatSinh;
    }

    public String getChuan(String ngay) {
        StringBuilder s = new StringBuilder(ngay);
        if (s.charAt(1) == '/')
            s.insert(0, '0');
        if (s.charAt(4) == '/')
            s.insert(3, '0');
        return s.toString().trim();
    }

    public int getDonGia() {
        int gia = 0;
        String tang = soPhong.substring(0, 1);
        switch (tang) {
        case "1":
            gia = 25;
            break;
        case "2":
            gia = 34;
            break;
        case "3":
            gia = 50;
            break;
        case "4":
            gia = 80;
            break;
        }
        return gia;
    }

    public int getSoNgayO() {
        return (int) ChronoUnit.DAYS.between(ngayNhan, ngayTra);
    }

    public int getTongTien() {
        return getSoNgayO() * getDonGia() + tienPhatSinh;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + soPhong + " " + getSoNgayO() + " " + getTongTien();
    }
}

public class J05016_HoaDonKhachSan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<KhachSan> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String soPhong = sc.nextLine();
            String ngayNhan = sc.nextLine();
            String ngayTra = sc.nextLine();
            int tienPhatSinh = Integer.parseInt(sc.nextLine());
            a.add(new KhachSan(name, soPhong, ngayNhan, ngayTra, tienPhatSinh));
        }

        a.sort((x, y) -> y.getTongTien() - x.getTongTien());

        for (KhachSan i : a) {
            System.out.println(i);
        }

        sc.close();
    }
}
