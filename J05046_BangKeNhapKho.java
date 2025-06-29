import java.util.*;

class NhapKho {
    private String id, name;
    private int soLuong, donGia;

    public NhapKho() {}

    public void Input(Scanner sc) {
        name = sc.nextLine();
        soLuong = Integer.parseInt(sc.nextLine());
        donGia = Integer.parseInt(sc.nextLine());
    }

    public double getPhanTramChietKhau() {
        if (soLuong > 10) return 0.05;
        if (soLuong >= 8) return 0.02;
        if (soLuong >= 5) return 0.01;
        return 0.0;
    }

    public int getTienChietKhau() {
        return (int) (donGia * soLuong * getPhanTramChietKhau());
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getThanhTien() {
        return donGia * soLuong - getTienChietKhau();
    }

    @Override
    public String toString() {
        return id + " " + name + " " + getTienChietKhau() + " " + getThanhTien();
    }
}

public class J05046_BangKeNhapKho {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<NhapKho> a = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            NhapKho h = new NhapKho();
            h.Input(sc);

            String[] words = h.getName().trim().split("\\s+");
            String code = words[0].substring(0, 1).toUpperCase() + words[1].substring(0, 1).toUpperCase();

            int serial = map.getOrDefault(code, 0) + 1;
            map.put(code, serial);

            h.setId(code + String.format("%02d", serial));
            a.add(h);
        }

        for (NhapKho i : a) {
            System.out.println(i);
        }
        sc.close();
    }
}
