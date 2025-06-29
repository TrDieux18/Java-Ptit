import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

class MatHang {
    private String id, ten, dvt;
    private int buy, purchase;
    public static int cnt = 1;

    public MatHang() {
    }

    public MatHang(String id, String ten, String dvt, int buy, int purchase) {
        this.id = id;
        this.ten = ten;
        this.dvt = dvt;
        this.buy = buy;
        this.purchase = purchase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public int getPurchase() {
        return purchase;
    }

    public void setPurchase(int purchase) {
        this.purchase = purchase;
    }

    public void input(Scanner sc) {
        id = "MH" + String.format("%03d", cnt++);
        sc.nextLine();
        ten = sc.nextLine();
        dvt = sc.nextLine();
        buy = sc.nextInt();
        purchase = sc.nextInt();
    }

    public int getLoi() {
        return purchase - buy;
    }

    public void output() {
        System.out.println(id + " " + ten + " " + dvt + " " + buy + " " + purchase + " " + getLoi());
    }
}

public class J05081_DanhSachMatHang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<MatHang> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            MatHang mh = new MatHang();
            mh.input(sc);
            a.add(mh);
        }

        // Sắp xếp danh sách theo lợi nhuận giảm dần, nếu lợi nhuận bằng nhau thì sắp xếp theo mã tăng dần
        Collections.sort(a, new Comparator<MatHang>() {
            public int compare(MatHang x, MatHang y) {
                if (x.getLoi() != y.getLoi()) {
                    return y.getLoi() - x.getLoi(); 
                }
                return x.getId().compareTo(y.getId());
            }
        });

        // Collections.sort(a, new Comparator<MatHang>() {
        //     public int compare1(MatHang x, MatHang y)
        // });
        for (MatHang mh : a) {
            mh.output();
        }
        sc.close();
    }
}
