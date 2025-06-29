import java.util.*;

class DoanhNghiep {

    private String id, name;
    private int cnt;

    public DoanhNghiep() {

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

public class J05028_DanhSachDoanhNghiepNhanSinhVienThucTap1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<DoanhNghiep> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            DoanhNghiep dn = new DoanhNghiep();
            dn.Input(sc);
            a.add(dn);
        }

        Collections.sort(a, new Comparator<DoanhNghiep>() {
            public int compare(DoanhNghiep x, DoanhNghiep y) {
                if(x.getCnt() != y.getCnt()){
                    return y.getCnt() - x.getCnt();
                }
                return x.getId().compareTo(y.getId());
            }
        });

        for(DoanhNghiep i : a){
            System.out.println(i);
        }

    }
}