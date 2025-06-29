import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

class TuyenDung {

    private String ms, hoten;
    private double dlt, dth;
    public static int cnt = 1;

    public void Input(Scanner sc) {
        ms = "TS" + String.format("%02d", cnt++);
        hoten = sc.nextLine();
        dlt = Double.parseDouble(sc.nextLine());
        dth = Double.parseDouble(sc.nextLine());
    }

    public double getDiemTB() {
        if (dlt <= 10 && dth <= 10) {
            return (dth + dlt) / 2;
        } else {
            return (dth + dlt) / 20;
        }
    }

    public String getMs() {
        return ms;
    }

    public String getXepLoai() {
        if (getDiemTB() < 5) {
            return "TRUOT";
        } else if (getDiemTB() >= 5 && getDiemTB() < 8) {
            return "CAN NHAC";
        } else if (getDiemTB() >= 8 && getDiemTB() <= 9.5) {
            return "DAT";
        } else {
            return "XUAT SAC";
        }
    }

    @Override
    public String toString() {
        return ms + " " + hoten + " " + String.format("%.2f", getDiemTB()) + " " + getXepLoai();
    }

}

public class J05013_TuyenDung {

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<TuyenDung> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            TuyenDung td = new TuyenDung();
            td.Input(sc);
            a.add(td);
        }

        Collections.sort(a, new Comparator<TuyenDung>() {
            public int compare(TuyenDung x, TuyenDung y) {
                int compareResult = Double.compare(y.getDiemTB(), x.getDiemTB()); 
                if (compareResult != 0) {
                    return compareResult;
                }
                return x.getMs().compareTo(y.getMs());
            }
        });

        for (TuyenDung i : a) {
            System.out.println(i);
        }
    }
}
