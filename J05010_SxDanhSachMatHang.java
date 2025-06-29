import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class DsMatHang {

    private int mmh;
    private String name, loai;
    private double buy, pur;
    public static int cnt = 1;

    public DsMatHang() {
        
    }

    public int getMmh() {
        return mmh;
    }

    public void input(Scanner sc) {
        mmh = cnt++;
        name = sc.nextLine();
        loai = sc.nextLine();
        buy = Double.parseDouble(sc.nextLine());
        pur = Double.parseDouble(sc.nextLine());
    }

    public double getLoi() {
        return this.pur - this.buy;
    }

    @Override
    public String toString() {
        
        return mmh + " " + name + " " + loai + " " + String.format("%.2f", getLoi());
    }
};

public class J05010_SxDanhSachMatHang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<DsMatHang> list= new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            DsMatHang x = new DsMatHang();
            x.input(sc);
            list.add(x);
        }

        Collections.sort(list, (x, y) -> Double.compare(y.getLoi(), x.getLoi()));


        for (DsMatHang i : list) {
            System.out.println(i);
        }
    }
}
