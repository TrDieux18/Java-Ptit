import java.util.*;

class ThoiGian {

    private int gio;
    private int phut;
    private int giay;

    public ThoiGian() {
    }

    public void Input(Scanner sc) {
        gio = sc.nextInt();
        phut = sc.nextInt();
        giay = sc.nextInt();
    }

    public int getGio() {
        return gio;
    }

    public int getPhut() {
        return phut;
    }

    public int getGiay() {
        return giay;
    }

    @Override
    public String toString() {
        return gio + " " + phut + " " + giay;
    }
}

public class J05033_SapXepThoiGian {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ThoiGian> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ThoiGian tg = new ThoiGian();
            tg.Input(sc);
            a.add(tg);
        }

        Collections.sort(a, new Comparator<ThoiGian>() {
            public int compare(ThoiGian x, ThoiGian y) {
                if (x.getGio() != y.getGio()) {
                    return x.getGio() - y.getGio();
                } else if (x.getPhut() != y.getPhut()) {
                    return x.getPhut() - y.getPhut();
                } else {
                    return x.getGiay() - y.getGiay();
                }
            }
        });

        for (ThoiGian tg : a) {
            System.out.println(tg);
        }
        sc.close();
    }
}
