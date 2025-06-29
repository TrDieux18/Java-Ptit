import java.util.*;

class HocBong {

    private String name, hocBong;
    private double gpa;
    private int rl;

    public HocBong(String name, double gpa, int rl) {
        this.name = chuanHoa(name);
        this.gpa = gpa;
        this.rl = rl;
        this.hocBong = xetHocBong();
    }

    public String chuanHoa(String s) {
        String[] word = s.trim().split("\\s+");
        String res = "";
        for (String w : word) {
            res += Character.toUpperCase(w.charAt(0)) + w.substring(1).toLowerCase() + " ";
        }
        return res.trim();
    }

    private String xetHocBong() {
        if (gpa >= 3.6 && rl >= 90)
            return "XUATSAC";
        if (gpa >= 3.2 && rl >= 80)
            return "GIOI";
        if (gpa >= 2.5 && rl >= 70)
            return "KHA";
        return "KHONG";
    }

    public String getHocBong() {
        return hocBong;
    }

    public void setHocBong(String hocBong) {
        this.hocBong = hocBong;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return name + ": " + hocBong;
    }

    public int getRl() {
        return rl;
    }

};

public class J05062_HocBongSinhVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        List<HocBong> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double gpa = sc.nextDouble();
            int rl = sc.nextInt();
            sc.nextLine();
            list.add(new HocBong(name, gpa, rl));
        }

        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if (cnt != m - 1) {
                cnt++;
            } else {
                list.get(cnt + 1).setHocBong("KHONG");
            }

        }

        for (HocBong i : list) {
            System.out.println(i);
        }
        sc.close();
    }
}