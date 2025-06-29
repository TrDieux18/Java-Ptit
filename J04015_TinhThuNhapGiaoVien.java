import java.util.Scanner;

class GiaoVien {
    private String id, hoten;
    private int sal;

    public GiaoVien() {

    }

    public GiaoVien(String id, String hoten, int sal) {
        this.id = id;
        this.hoten = hoten;
        this.sal = sal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        id = sc.nextLine();
        hoten = sc.nextLine();
        sal = sc.nextInt();
        sc.close();
    }

    public void output() {
        int ma = Integer.parseInt(id.substring(2));
        int phucap = 0;
        if (id.substring(0, 2).equals("HT")) {
            phucap = 2000000;
        }
        if (id.substring(0, 2).equals("HP")) {
            phucap = 900000;
        }
        if (id.substring(0, 2).equals("GV")) {
            phucap = 500000;
        }
        int luong = sal * ma + phucap;
        System.out.println(id + " " + hoten + " " + ma + " " + phucap + " " + luong);
    }
}

public class J04015_TinhThuNhapGiaoVien {

    public static void main(String[] args) {
        GiaoVien gv = new GiaoVien();
        gv.input();
        gv.output();
    }
}