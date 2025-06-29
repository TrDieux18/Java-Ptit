import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

class XT {

    private String id, name, dob;
    private double theory, practice;
    public static int cnt = 1;

    public XT() {
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

    public String ChuanHoa(String s) {
        String[] words = s.trim().toLowerCase().split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (String i : words) {
            ans.append(Character.toUpperCase(i.charAt(0))).append(i.substring(1)).append(" ");
        }
        return ans.toString().trim();
    }

    @Override
    public String toString() {
        return id + " " + ChuanHoa(name) + " " + getAge() + " " + (int) getDiemTB() + " " + getXepLoai();
    }
}

public class J07053_XetTuyen {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("XETTUYEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        XT[] a = new XT[n];
        for (int i = 0; i < n; i++) {
            a[i] = new XT();
            a[i].Input(sc);
        }

        for (XT i : a) {
            System.out.println(i);
        }
    }
}