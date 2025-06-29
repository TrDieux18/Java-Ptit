import java.util.*;

class CLB {
    private String id, name;
    private int giaVe;

    public CLB(String id, String name, int giaVe) {
        this.id = id;
        this.name = name;
        this.giaVe = giaVe;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGiaVe() {
        return giaVe;
    }
}

class TD {
    private String idtrandau;
    private int socoDongVien;
    private CLB clb;

    public TD(String idtrandau, int socoDongVien, CLB clb) {
        this.idtrandau = idtrandau;
        this.socoDongVien = socoDongVien;
        this.clb = clb;
    }

    public long getDoanhThu() {
        return clb.getGiaVe() * socoDongVien;
    }

    @Override
    public String toString() {
        return idtrandau + " " + clb.getName() + " " + getDoanhThu();
    }
}

public class J05069_CauLacBoBongDa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        // Danh sách các câu lạc bộ
        List<CLB> clbList = new ArrayList<>();

        // Đọc thông tin các câu lạc bộ
        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            int giaVe = Integer.parseInt(sc.nextLine());
            clbList.add(new CLB(id, name, giaVe));
        }

        int m = Integer.parseInt(sc.nextLine());
        List<TD> dsTranDau = new ArrayList<>();

        // Đọc thông tin các trận đấu
        for (int i = 0; i < m; i++) {
            String[] tranDauInfo = sc.nextLine().split(" ");
            String idtrandau = tranDauInfo[0];
            int socoDongVien = Integer.parseInt(tranDauInfo[1]);

            // Lấy mã CLB từ id trận đấu
            String clbId = idtrandau.substring(1, 3);
            CLB clb = null;

            // Tìm CLB theo mã trong danh sách
            for (CLB c : clbList) {
                if (c.getId().equals(clbId)) {
                    clb = c;
                    break;
                }
            }

            // Tạo đối tượng trận đấu và thêm vào danh sách
            if (clb != null) {
                dsTranDau.add(new TD(idtrandau, socoDongVien, clb));
            }
        }

        // In kết quả
        for (TD tranDau : dsTranDau) {
            System.out.println(tranDau);
        }
        sc.close();
    }
}
