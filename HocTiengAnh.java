// package CodeJ;

import java.util.ArrayList;
import java.util.Scanner;

class TuVung {
    private String tiengAnh;
    private String tiengViet;

    public TuVung(String tiengAnh, String tiengViet) {
        this.tiengAnh = tiengAnh;
        this.tiengViet = tiengViet;
    }

    public String getTiengAnh() {
        return tiengAnh;
    }

    public String getTiengViet() {
        return tiengViet;
    }

    public void hienThiTu() {
        System.out.println("Tiếng Anh: " + tiengAnh + " - Tiếng Việt: " + tiengViet);
    }
}

public class HocTiengAnh {
    private static ArrayList<TuVung> danhSachTuVung = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int luaChon;

        do {
            System.out.println("=== Chào mừng đến với phần mềm học tiếng Anh ===");
            System.out.println("1. Thêm từ vựng mới");
            System.out.println("2. Xem danh sách từ vựng");
            System.out.println("3. Kiểm tra từ vựng");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = sc.nextInt();
            sc.nextLine(); // Bỏ qua dòng trống sau khi nhập số

            switch (luaChon) {
                case 1:
                    themTuVung();
                    break;
                case 2:
                    xemDanhSachTuVung();
                    break;
                case 3:
                    kiemTraTuVung();
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (luaChon != 4);
    }

    private static void themTuVung() {
        System.out.print("Nhập từ tiếng Anh: ");
        String tiengAnh = sc.nextLine();
        System.out.print("Nhập nghĩa tiếng Việt: ");
        String tiengViet = sc.nextLine();

        TuVung tuVung = new TuVung(tiengAnh, tiengViet);
        danhSachTuVung.add(tuVung);
        System.out.println("Thêm từ vựng thành công!");
    }

    private static void xemDanhSachTuVung() {
        if (danhSachTuVung.isEmpty()) {
            System.out.println("Chưa có từ vựng nào.");
        } else {
            System.out.println("Danh sách từ vựng:");
            for (TuVung tuVung : danhSachTuVung) {
                tuVung.hienThiTu();
            }
        }
    }

    private static void kiemTraTuVung() {
        if (danhSachTuVung.isEmpty()) {
            System.out.println("Chưa có từ vựng để kiểm tra.");
            return;
        }

        int dung = 0, sai = 0;

        for (TuVung tuVung : danhSachTuVung) {
            System.out.print("Nghĩa của từ '" + tuVung.getTiengAnh() + "' là gì? ");
            String cauTraLoi = sc.nextLine();

            if (cauTraLoi.equalsIgnoreCase(tuVung.getTiengViet())) {
                System.out.println("Chính xác!");
                dung++;
            } else {
                System.out.println("Sai rồi! Đáp án đúng là: " + tuVung.getTiengViet());
                sai++;
            }
        }

        System.out.println("Kết quả kiểm tra: " + dung + " đúng, " + sai + " sai.");
    }
}
