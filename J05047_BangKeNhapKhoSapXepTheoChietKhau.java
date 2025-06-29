import java.util.*;

class Nhapkho {

    private String id, name;
    private int soLuong, donGia;

    public Nhapkho() {
    }

    public void Input(Scanner sc) {
        name = sc.nextLine();
        soLuong = Integer.parseInt(sc.nextLine());
        donGia = Integer.parseInt(sc.nextLine());
    }

    public double getPhanTramChietKhau() {
        if (soLuong > 10)
            return 0.05;
        if (soLuong >= 8)
            return 0.02;
        if (soLuong >= 5)
            return 0.01;
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
};

public class J05047_BangKeNhapKhoSapXepTheoChietKhau {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Nhapkho> a = new ArrayList<>(n);
        Map<String, Integer> mp = new HashMap<>();

        for(int i = 0; i < n; i++){
            Nhapkho h = new Nhapkho();
            h.Input(sc);

            String[] words = h.getName().trim().split("\\s+");
            String code = words[0].substring(0,1).toUpperCase() + words[1].substring(0, 1).toUpperCase();

            int serial = mp.getOrDefault(code, 0)+1;
            mp.put(code, serial);

            h.setId(code + String.format("%02d", serial));
            a.add(h);
        }

        Collections.sort(a, new Comparator<Nhapkho>() {
            public int compare(Nhapkho x, Nhapkho y){
                return y.getTienChietKhau() - x.getTienChietKhau();
            }
        });

        for(Nhapkho i : a){
            System.out.println(i);
        }
    }

}
