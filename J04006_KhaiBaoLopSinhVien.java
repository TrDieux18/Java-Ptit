import java.util.Scanner;

class SinhVien1 {
    private String msv, hoten, lop, ngaysinh;
    private float gpa;

    public SinhVien1() {

    }

    public SinhVien1(String msv, String hoten, String lop, String ns, float gpa) {
        this.msv = msv;
        this.hoten = hoten;
        this.lop = lop;
        this.ngaysinh = ns;
        this.gpa = gpa;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaySinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        msv = "B20DCCN001";
        hoten = sc.nextLine();
        lop = sc.nextLine();
        ngaysinh = sc.nextLine();
        if (ngaysinh.charAt(2) != '/') {
            ngaysinh = "0" + ngaysinh;
        }
        if (ngaysinh.charAt(5) != '/') {
            ngaysinh = ngaysinh.substring(0, 3) + "0" + ngaysinh.substring(3);
        }
        gpa = sc.nextFloat();
        sc.close();
    }

    public void output() {
        System.out.printf("%s %s %s %s %.2f", msv, hoten, lop, ngaysinh, gpa);
    }
}

public class J04006_KhaiBaoLopSinhVien {

    public static void main(String[] args) {
        SinhVien1 sv = new SinhVien1();
        sv.input();
        sv.output();
    }
}