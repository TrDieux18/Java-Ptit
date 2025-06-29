import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

class MONHOC {
    private String id, name;
    private int stc;

    public MONHOC() {

    }

    public void Input(Scanner sc) {
        id = sc.nextLine();
        name = sc.nextLine();
        stc = Integer.parseInt(sc.nextLine());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + stc;
    }

}

public class DanhSachMonHoc {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<MONHOC> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            MONHOC mh = new MONHOC();
            mh.Input(sc);
            a.add(mh);
        }

        a.sort((x, y) -> x.getName().compareTo(y.getName()));
        for (MONHOC i : a) {
            System.out.println(i);
        }
        sc.close();
    }

}
