import java.util.*;

class hocsinh {

    private String id, name;
    private double diemTB;
    public static int cnt = 1;

    public hocsinh() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void Input(Scanner sc) {
        id = "HS" + String.format("%02d", cnt++);
        name = sc.nextLine();
        diemTB = Double.parseDouble(sc.nextLine());
        if (diemTB < 0 || diemTB > 10)
            return;
    }

    public String getXepLoai() {
        if (diemTB < 5) {
            return "Yeu";
        } else if (diemTB < 7) {
            return "Trung Binh";
        } else if (diemTB < 9) {
            return "Kha";
        } else {
            return "Gioi";
        }
    }

    @Override
    public String toString() {
        return id + " " + name + " " + String.format("%.1f", getDiemTB()) + " " + getXepLoai();
    }
}

public class J05054_XepHangHocSinh {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<hocsinh> a = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            hocsinh hs = new hocsinh();
            hs.Input(sc);
            a.add(hs);
        }

        List<hocsinh> listsx = new ArrayList<>(a);
        listsx.sort((x, y) -> Double.compare(y.getDiemTB(), x.getDiemTB()));

        Map<hocsinh, Integer> xepHang = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < listsx.size(); i++) {
            if (i > 0 && listsx.get(i).getDiemTB() == listsx.get(i - 1).getDiemTB()) {
                xepHang.put(listsx.get(i), xepHang.get(listsx.get(-1)));
            } else {
                xepHang.put(listsx.get(i), rank);
            }
            rank++;
        }
        for (hocsinh i : a) {
            System.out.println(i + " " + xepHang.get(i));
        }
        sc.close();
    }
}
