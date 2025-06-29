import java.util.*;

class DsNhanVien {
    private String mnv, hoten, gt, dob, add, tax, date;
    public static int cnt = 1;

    public DsNhanVien() {

    }

    public void input(Scanner sc) {

        mnv = String.format("%05d", cnt++);
        hoten = sc.nextLine();
        gt = sc.nextLine();
        dob = sc.nextLine();
        if (dob.charAt(2) != '/') {
            dob = "0" + dob;
        }
        if (dob.charAt(5) != '/') {
            dob = dob.substring(0, 3) + "0" + dob.substring(3);
        }

        add = sc.nextLine();
        tax = sc.nextLine();
        date = sc.nextLine();
        if (date.charAt(2) != '/') {
            date = "0" + date;
        }
        if (date.charAt(5) != '/') {
            date = date.substring(0, 3) + "0" + date.substring(3);
        }
    }

    @Override
    public String toString() {
        return mnv + " " + hoten + " " + gt + " " + dob + " " + add + " " + tax + " " + date;
    }

    public String formatDob() {
        String[] dobs = dob.split("/");
        return dobs[2] + dobs[1] + dobs[0];
    }
}

public class J05007_SxDanhSachDoiTuongNhanVien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<DsNhanVien> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            DsNhanVien nv = new DsNhanVien();
            nv.input(sc);
            a.add(nv);
        }
        a.sort( new Comparator<DsNhanVien>() {
            public int compare(DsNhanVien x, DsNhanVien y) {
                return x.formatDob().compareTo(y.formatDob());
            }
        });

        for(DsNhanVien i : a){
            System.out.println(i);
        }
    }
}