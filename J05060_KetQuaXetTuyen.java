import java.util.Scanner;

class KQXT {

    private String id, name, dob;
    private double theory, practice;
    public static int cnt = 1;

    public KQXT() {
    }

    public void Input(Scanner sc) {
        id = "PH" + String.format("%02d", cnt++);
        name = sc.nextLine();
        dob = sc.nextLine();
        theory = Double.parseDouble(sc.nextLine());
        practice = Double.parseDouble(sc.nextLine());
    }

    public short getAge() {
        return (short) (2021 - Short.parseShort(dob.substring(dob.length() - 4)));
    }

    public double getDiemThuong() {
        if (theory >= 8 && practice >= 8) {
            return 1.0;
        } else if (theory >= 7.5 && practice >= 7.5) {
            return 0.5;
        } else {
            return 0;
        }
    }

    public double getDiemTB() {
        double diemTB = (theory + practice) / 2 + getDiemThuong();
        diemTB = Math.round(diemTB);
        return Math.min(diemTB, 10);
    }

    public String getXepLoai() {
        double diemTB = getDiemTB();
        if (diemTB >= 9)
            return "Xuat sac";
        else if (diemTB == 8)
            return "Gioi";
        else if (diemTB == 7)
            return "Kha";
        else if (diemTB < 5)
            return "Truot";
        else
            return "Trung binh";
    }

    @Override
    public String toString() {
        return id + " " + name + " " + getAge() + " " + (int) getDiemTB() + " " + getXepLoai();
    }
}

public class J05060_KetQuaXetTuyen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        KQXT[] a = new KQXT[n];
        for (int i = 0; i < n; i++) {
            a[i] = new KQXT();
            a[i].Input(sc);
        }

        for (KQXT i : a) {
            System.out.println(i);
        }
    }
}