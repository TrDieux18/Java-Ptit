import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class DSF {
    public String ma, hoten, lop, email;

    public DSF(String ma, String hoten, String lop, String email) {
        this.ma = ma;
        this.hoten = formatTen(hoten);
        this.lop = lop;
        this.email = email;
    }

    public String formatTen(String s) {
        String[] word = s.trim().split("\\s+");
        String res = "";
        for (int i = 0; i < word.length; i++) {
            res += word[i].substring(0, 1).toUpperCase() + word[i].substring(1).toLowerCase() + " ";
            if (i != word.length - 1)
                res += " ";
        }
        return res;
    }

    public String getMa() {
        return ma;
    }

    @Override
    public String toString() {
        return ma + " " + hoten + " " + lop + " " + email;
    }
}

public class J07033_DanhSachSinhVienTrongFile1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<DSF> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String hoten = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            list.add(new DSF(ma, hoten, lop, email));
        }
        list.sort((x, y) -> x.getMa().compareTo(y.getMa()));
        for (DSF i : list) {
            System.out.println(i);
        }
        sc.close();
    }
}
