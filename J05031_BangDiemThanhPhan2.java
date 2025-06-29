import java.util.*;
// import java.time.format.;

class Bangdiem {

    private String id, name, lop;
    private double diem1, diem2, diem3;

    public Bangdiem() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void Input(Scanner sc) {
        id = sc.nextLine();
        name = sc.nextLine();
        lop = sc.nextLine();
        diem1 = Double.parseDouble(sc.nextLine());
        diem2 = Double.parseDouble(sc.nextLine());
        diem3 = Double.parseDouble(sc.nextLine());
    }

    @Override
    public String toString() {
        return id + " " + name + " " + lop + " " + String.format("%.1f", diem1) + " " + String.format("%.1f", diem2)
                + " " + String.format("%.1f", diem3);
    }

};

public class J05031_BangDiemThanhPhan2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Bangdiem> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            Bangdiem bd = new Bangdiem();
            bd.Input(sc);
            a.add(bd);
        }

        Collections.sort(a, new Comparator<Bangdiem>() {
            public int compare(Bangdiem x, Bangdiem y) {
                return x.getName().compareTo(y.getName());
            }
        });

        int cnt = 0;
        for (Bangdiem x : a) {
            cnt++;
            System.out.println(cnt + " " + x);
        }
    }
}
