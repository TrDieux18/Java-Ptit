import java.util.*;

class Doanhnghiep {

    private String id, name;
    private int cnt;

    public Doanhnghiep() {

    }

    public String getId() {
        return id;
    }

    public int getCnt() {
        return cnt;
    }

    public void Input(Scanner sc) {
        id = sc.nextLine();
        name = sc.nextLine();
        cnt = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String toString() {
        return id + " " + name + " " + cnt;
    }
};

public class J05029_DanhSachDoanhNghiepNhanSinhVienThucTap2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Doanhnghiep> ds = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            Doanhnghiep dn = new Doanhnghiep();
            dn.Input(sc);
            ds.add(dn);
        }

        Collections.sort(ds, new Comparator<Doanhnghiep>() {
            public int compare(Doanhnghiep x, Doanhnghiep y) {
                if(x.getCnt() != y.getCnt()){
                    return y.getCnt() - x.getCnt();
                }
                return x.getId().compareTo(y.getId());
            }
        });

        int q = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < q; i++){
            int  a = Integer.parseInt(sc.next());
            int b = Integer.parseInt(sc.next());
            System.out.println("DANH SACH DOANH NGHIEP NHAN TU " + a + " DEN " + b +" SINH VIEN:");
            for(Doanhnghiep x : ds){
                if(x.getCnt() >= a && x.getCnt() <= b){
                    System.out.println(x);
                }
            }
        }

    }
}