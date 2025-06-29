import java.util.*;

class TienNuoc {
    private String id, name;
    private int chiSoCu, chiSoMoi;

    public static int cnt = 1;

    public TienNuoc(String name, int chiSoCu, int chiSoMoi) {
        this.id = String.format("KH%02d", cnt++);
        this.name = name;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
    }

    public int getChiSo() {
        return chiSoMoi - chiSoCu;
    }

    public double getSoTien() {
        int chiSo = getChiSo();
        int gia = 0;
        double phuPhi = 0;
        if (chiSo <= 50) {
            gia = 100 * chiSo;
            phuPhi = gia * 0.02;
        } else if (chiSo > 100) {
            gia = 50 * 100 + 50 * 150 + (chiSo - 100) * 200;
            phuPhi = gia * 0.05;
        } else {
            gia =100 * 50 + 150 * (chiSo - 50);
            phuPhi = gia * 0.03;
        }
        return Math.round((gia + phuPhi));
    }

    @Override
    public String toString() {
        return id + " " + name + " " + String.format("%.0f", getSoTien());
    }

};

public class J05017_HoaDonTienNuoc {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<TienNuoc> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int chiSoCu = Integer.parseInt(sc.nextLine());
            int chiSoMoi = Integer.parseInt(sc.nextLine());
            a.add(new TienNuoc(name, chiSoCu, chiSoMoi));
        }

        a.sort((x, y) -> Double.compare(y.getSoTien(), x.getSoTien()));
        for (TienNuoc i : a) {
            System.out.println(i);
        }
        sc.close();
    }
}
