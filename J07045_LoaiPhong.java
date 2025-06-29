import java.util.*;
import java.io.File;
// import java.io.FileNotFoundException;
import java.io.IOException;

class LoaiPhong implements Comparable<LoaiPhong> {

    private String id, name;
    private int gia;
    private double phi;

    public LoaiPhong(String data) {
        String[] parts = data.split(" ");
        this.id = parts[0];
        this.name = parts[1];
        this.gia = Integer.parseInt(parts[2]);
        this.phi = Double.parseDouble(parts[3]);
    }

    public int compareTo(LoaiPhong o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + gia + " " + phi;
    }
};

public class J07045_LoaiPhong {

    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while (n-- > 0) {
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for (LoaiPhong tmp : ds) {
            System.out.println(tmp);
        }
        in.close();
    }
}
