import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class DSSP2 {

    private String id, name;
    private int giaban, thang;

    public DSSP2(String id, String name, int giaban, int thang) {
        this.id = id;
        this.name = name;
        this.giaban = giaban;
        this.thang = thang;
    }

    public String getId() {
        return id;
    }

    public int getGiaban() {
        return giaban;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + giaban + " " + thang;
    }

}

public class J07048_DanhSachSanPham2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./SANPHAM.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<DSSP2> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            int gia = Integer.parseInt(sc.nextLine());
            int thang = Integer.parseInt(sc.nextLine());
            list.add(new DSSP2(id, name, gia, thang));
        }

        list.sort((x, y) -> (x.getGiaban() != y.getGiaban()) ? y.getGiaban() - x.getGiaban()
                : x.getId().compareTo(y.getId()));

        for (DSSP2 i : list) {
            System.out.println(i);
        }
        sc.close();
    }
}
