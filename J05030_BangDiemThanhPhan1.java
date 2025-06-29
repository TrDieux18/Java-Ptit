import java.util.*;

class BangDiem {

    private String id, name, lop;
    private double diem1, diem2, diem3;

    public BangDiem() {

    }

    public String getId() {
        return id;
    }

    public void Input(Scanner sc) {
        id = sc.nextLine();
        name = sc.nextLine();
        lop = sc.nextLine();
        diem1 = Double.parseDouble(sc.nextLine());
        diem2 = Double.parseDouble(sc.nextLine());
        diem3 = Double.parseDouble(sc.nextLine());
    }

    public double getTong() {
        return diem1 + diem2 + diem3;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + lop + " " + String.format("%.1f", diem1) + " " + String.format("%.1f", diem2)+ " " + String.format("%.1f", diem3);
    }

};

public class J05030_BangDiemThanhPhan1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<BangDiem> a = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            BangDiem bd =  new BangDiem();
            bd.Input(sc);
            a.add(bd);
        }

        Collections.sort(a, new Comparator<BangDiem>() {
            public int compare(BangDiem x, BangDiem y){
                return x.getId().compareTo(y.getId());
            }
        });

        int cnt = 0;
        for(BangDiem x : a){
            cnt++;
            System.out.println(cnt +" " + x);
        }
    }
}
